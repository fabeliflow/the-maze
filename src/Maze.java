import java.util.Scanner;

/**
 * The Maze class represents an individual maze, a two-dimensional array of
 * cells.
 * 
 * @author fiorfe
 * 
 */
public class Maze {

	int rows;
	int columns;

	int colCount; // column count to facilitate input reading

	String strRow; // string representation for each row from file input

	boolean found; // path found flag

	Cell arrayCells[][]; // array of cells

	/**
	 * Constructor. It creates a new Maze from a Scanner object.
	 * 
	 * @param s
	 * 
	 */
	public Maze(Scanner s) {

		found = false;

		rows = s.nextInt(); // read rows from input
		columns = s.nextInt(); // read columns from input

		// instantiate the array of cells
		arrayCells = new Cell[rows][columns];

		s.nextLine();

		// create blank cells
		for (int r = 0; r < rows; r++) {

			for (int c = 0; c < columns; c++) {

				arrayCells[r][c] = new Cell();
			}
		}

		buildWall();

		strRow = s.nextLine();

		// populate array of cells with given data
		for (int r = 0; r < rows; r++) {

			strRow = s.nextLine();

			colCount = 0;

			for (int c = 1; c < strRow.length(); c++) {

				if (strRow.charAt(c) == '_') {

					arrayCells[r][colCount].setSouth(true);

				}

				c++;

				if (strRow.charAt(c) == '|') {

					arrayCells[r][colCount].setEast(true);
				}

				colCount++;
			}
		}
	}

	/**
	 * This method creates a wall around the maze.
	 * 
	 */
	public void buildWall() {

		for (int c = 1; c < columns; c++) {

			arrayCells[0][c].setNorth(true);
		}

		for (int c = 0; c < columns - 1; c++) {

			arrayCells[rows - 1][c].setSouth(true);
		}

		for (int r = 0; r < rows; r++) {

			arrayCells[r][columns - 1].setEast(true);

			arrayCells[r][0].setWest(true);
		}
	}

	/**
	 * This method returns a text representation of the maze without the first
	 * two lines giving the numbers of rows and columns.
	 * 
	 * @return strMaze
	 * 
	 */
	public String asText() {

		String strMaze = "";

		if (pathFound()) {

			strMaze += (" @ ");

		} else {

			strMaze += ("   ");
		}

		for (int c = 1; c < arrayCells[0].length; c++) {

			strMaze += ("_" + " ");
		}

		strMaze += "\r\n";

		for (int r = 0; r < arrayCells.length; r++) {

			strMaze += ("|");

			for (int c = 0; c < arrayCells[0].length; c++) {

				Cell col = arrayCells[r][c];

				if (col.getNeighbor(1) == true) {

					if (col.isOnPath()) {

						strMaze += ("@");

					} else {

						strMaze += ("_");
					}

				} else {

					if (col.isOnPath()) {

						strMaze += ("@");

					} else {

						strMaze += (" ");
					}
				}

				if (col.getNeighbor(0) == true) {

					strMaze += ("|");

				} else {

					strMaze += (" ");
				}
			}

			strMaze += "\r\n";
		}

		if (pathFound()) {

			for (int c = 0; c < strRow.length() - 2; c++) {

				strMaze += (" ");
			}

			strMaze += ("@");
		}

		return strMaze;
	}

	/**
	 * This method determines if a path exists through the maze from the
	 * starting position to the finishing position. If so, records a path in the
	 * internal representation. The starting position is always assumed to be in
	 * the upper left corner while the finishing position is assumed to be in
	 * the lower right corner. If no path exists, the text returned by asText
	 * should be unaltered.
	 * 
	 */
	public void findPath() {

		Set<Location> setLoc = new Set<Location>(); // create a new set

		LinkedStack<Location> stack = new LinkedStack<Location>(); // create a
																	// new stack

		Location loc = new Location(-1, 0); // starting location

		Location next = loc.getLoc(1); // next location

		setLoc.enter(loc); // add starting location to the set

		stack.push(loc); // push starting location to the stack

		int index = 0; // index for neighbor

		int deadEnd = 0; // counter for dead end

		int nextRow = next.getRow(); // next location row

		int nextColumn = next.getColumn(); // next location column

		boolean myWall = false; // cell wall

		while (!stack.isEmpty()) {

			stack.pop();

			while (!pathFound()) {

				// if the final location is reached
				if (myWall == false && nextRow == rows - 1
						&& nextColumn == columns - 1) {

					setLoc.enter(next);

					stack.push(next);

					found = true;

					// if the path is not found, exit the while loop
				} else if (deadEnd == 3 && nextRow == 0 && nextColumn == 0) {

					break;

				} else {

					found = false;

					myWall = arrayCells[nextRow][nextColumn].getNeighbor(index);

					// if next location is not in the set and there is no wall
					// in index direction
					if (!(setLoc.isElement(next.getLoc(index)))
							&& myWall == false) {

						boolean nextWall = false;

						// check if there is no wall in the next cell at index
						// direction
						if (index == 0 && nextColumn != columns - 1) {

							nextWall = arrayCells[next.getLoc(index).getRow()][next
									.getLoc(index).getColumn()].getNeighbor(2);

						} else if (index == 1 && nextRow != rows - 1) {

							nextWall = arrayCells[next.getLoc(index).getRow()][next
									.getLoc(index).getColumn()].getNeighbor(3);

						} else if (index == 2 && nextColumn != 0) {

							nextWall = arrayCells[next.getLoc(index).getRow()][next
									.getLoc(index).getColumn()].getNeighbor(0);

						} else if (index == 3 && nextRow != -1) {

							nextWall = arrayCells[next.getLoc(index).getRow()][next
									.getLoc(index).getColumn()].getNeighbor(1);
						} else {

						}

						// if there is no wall in index direction
						if (myWall == nextWall) {

							loc = next; // save previous location

							next = next.getLoc(index); // go to next location

							next.setPrevious(loc); // set next's previous
													// location

							nextRow = next.getRow();

							nextColumn = next.getColumn();

							setLoc.enter(next); // add next location to the set

							stack.push(next); // push next location to the stack

							index = 0;

							deadEnd = 0;

						} else {

							// if dead end
							if (deadEnd == 3) {

								stack.pop(); // pop current location

								next = stack.peek(); // go one location back

								nextRow = next.getRow();

								nextColumn = next.getColumn();

								index = 0;

								deadEnd = 0;

							} else {

								deadEnd++;

								index++;
							}
						}

					} else {

						// if dead end
						if (deadEnd == 3) {

							stack.pop(); // pop current location

							next = stack.peek(); // go one location back

							nextRow = next.getRow();

							nextColumn = next.getColumn();

							index = 0;

							deadEnd = 0;

						} else {

							deadEnd++;

							index++;
						}
					}
				}
			}
		}

		// if path has been found, set the onPath variable of all the cells of
		// the grid that are located on the path
		if (pathFound()) {

			Location locPath = next;

			int pathRow = locPath.getRow();
			int pathColumn = locPath.getColumn();

			arrayCells[pathRow][pathColumn].setOnPath(true);

			while (locPath.previous() != null) {

				locPath = locPath.previous();

				pathRow = locPath.getRow();
				pathColumn = locPath.getColumn();

				arrayCells[pathRow][pathColumn].setOnPath(true);
			}
		}
	}

	/**
	 * This method indicates whether a path has yet been found through a given
	 * maze.
	 * 
	 * @return found
	 * 
	 */
	public boolean pathFound() {

		return found;
	}
}