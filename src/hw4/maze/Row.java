package hw4.maze;

import java.util.ArrayList;
/**
 * Represents a row within the grid, containing a list of cells.
 */
public class Row {
	private ArrayList<Cell> cells;
	/**
	 * Constructs a Row with the specified list of cells.
	 *
	 * @param cells the list of Cell objects in the row
	 */
	public Row(ArrayList<Cell> cells) {
		this.cells = cells;
	}
	/**
	 * Returns the list of cells in the row.
	 *
	 * @return an ArrayList of Cell objects
	 */
	public ArrayList<Cell> getCells() {
		return cells;
	}
	/**
	 * Sets the list of cells in the row.
	 *
	 * @param cells an ArrayList of Cell objects
	 */
	public void setCells(ArrayList<Cell> cells) {
		this.cells = cells;
	}
	/**
	 * Returns the cell at the specified index in the row.
	 *
	 * @param i the index of the cell to retrieve
	 * @return the Cell at the specified index
	 */
	public Cell getCell(int i) {
		return cells.get(i);
	}
	/**
	 * Returns a string representation of the row.
	 *
	 * @return a string describing the row
	 */
	@Override
	public String toString() {
		return "Row [cells=" + cells + "]";
	}

}
