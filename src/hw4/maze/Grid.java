package hw4.maze;

import java.util.ArrayList;
/**
 * Represents a grid structure consisting of multiple rows.
 * Each row contains a list of cells forming a 2D maze layout.
 */
public class Grid {
	private ArrayList<Row> rows;
	/**
	 * Constructs a Grid with the specified list of rows.
	 *
	 * @param rows the list of Row objects forming the grid
	 */
	public Grid(ArrayList<Row> rows) {
		this.rows = rows;
	}
	/**
	 * Returns the list of rows in the grid.
	 *
	 * @return an ArrayList of Row objects
	 */
	public ArrayList<Row> getRows() {
		return rows;
	}
	/**
	 * Sets the list of rows for the grid.
	 *
	 * @param rows an ArrayList of Row objects
	 */
	public void setRows(ArrayList<Row> rows) {
		this.rows = rows;
	}
	/**
	 * Returns the size of the grid (number of rows).
	 *
	 * @return the size of the grid
	 */
	public int getSize() {
		return rows.size();
	}
	/**
	 * Returns a string representation of the grid.
	 *
	 * @return a string describing the grid
	 */
	@Override
	public String toString() {
		return "Grid [rows=" + rows + "]";
	}

}
