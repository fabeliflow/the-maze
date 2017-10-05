/**
 * The Cell class represents an individual cell.
 * 
 * @author fiorfe
 * 
 */
public class Cell {

	// constant variables that represent each Cell neighbor
	public static final int EAST = 0;
	public static final int SOUTH = 1;
	public static final int WEST = 2;
	public static final int NORTH = 3;

	// four possible connections to other cells within a maze
	private boolean neighbors[] = new boolean[4];

	// represents either the Cell is on the path or not
	private boolean onPath;

	/**
	 * No-arg constructor. It sets onPath and its neighbors to false (blank
	 * cells).
	 * 
	 */
	public Cell() {

		neighbors[EAST] = false;
		neighbors[SOUTH] = false;
		neighbors[WEST] = false;
		neighbors[NORTH] = false;

		onPath = false;
	}

	/**
	 * Setter for neighbors[EAST]
	 * 
	 * @param e
	 */
	public void setEast(boolean e) {

		neighbors[EAST] = e;
	}

	/**
	 * Setter for neighbors[SOUTH]
	 * 
	 * @param s
	 */
	public void setSouth(boolean s) {

		neighbors[SOUTH] = s;
	}

	/**
	 * Setter for neighbors[WEST]
	 * 
	 * @param w
	 */
	public void setWest(boolean w) {

		neighbors[WEST] = w;
	}

	/**
	 * Setter for neighbors[NORTH]
	 * 
	 * @param n
	 */
	public void setNorth(boolean n) {

		neighbors[NORTH] = n;
	}

	/**
	 * Getter for neighbors[loc]
	 * 
	 * @return loc
	 */
	public boolean getNeighbor(int loc) {

		return neighbors[loc];
	}

	/**
	 * This method returns onPath
	 * 
	 * @return onPath
	 * 
	 */
	public boolean isOnPath() {

		return onPath;
	}

	/**
	 * Setter for onPath
	 * 
	 * @param onPath
	 */
	public void setOnPath(boolean onPath) {

		this.onPath = onPath;
	}
}