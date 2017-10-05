/**
 * The Location class represents a simple object that denotes a grid location of
 * the maze using the row and column of a grid cell.
 * 
 * @author fiorfe
 * 
 */
public class Location {

	private int row;
	private int column;

	private Location previous; // points to previous Location

	/**
	 * Constructor. It creates a new Location.
	 * 
	 * @param r
	 * @param c
	 * 
	 */
	public Location(int r, int c) {

		row = r;
		column = c;
		previous = null;
	}

	/**
	 * Getter for row
	 * 
	 * @return row
	 */
	public int getRow() {

		return row;
	}

	/**
	 * Getter for column
	 * 
	 * @return column
	 */
	public int getColumn() {

		return column;
	}

	/**
	 * Setter for previous
	 * 
	 * @param loc
	 */
	public void setPrevious(Location loc) {

		previous = loc;
	}

	/**
	 * Getter for previous
	 * 
	 * @return previous
	 */
	public Location previous() {

		return previous;
	}

	/**
	 * This method returns a Location object with coordinates of an adjacent
	 * cell on the grid in the given direction.
	 * 
	 * @param dir
	 * 
	 * @return adjacent
	 * 
	 */
	public Location getLoc(int dir) {

		Location adjacent = null;

		switch (dir) {

		case 0:

			adjacent = new Location(row, column + 1);

			break;

		case 1:

			adjacent = new Location(row + 1, column);

			break;

		case 2:

			adjacent = new Location(row, column - 1);

			break;

		case 3:

			adjacent = new Location(row - 1, column);

			break;
		}

		return adjacent;
	}

	/**
	 * Overridden equals method.
	 * 
	 */
	public boolean equals(Object obj) {

		Location s;

		if (obj instanceof Location) {

			s = (Location) obj;

			return (s.row == row && s.column == column);

		} else {

			return false;
		}
	}
}