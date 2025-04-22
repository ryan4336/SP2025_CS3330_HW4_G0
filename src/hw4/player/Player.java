package hw4.player;

import hw4.maze.Cell;
import hw4.maze.Row;
/**
 * Represents a player in the game.
 * The player is associated with a specific cell and row in the grid.
 */
public class Player {

	private Cell currentCell;
	private Row currentRow;
	/**
	 * Constructs a Player with a specified row and cell.
	 *
	 * @param row the row the player is currently in
	 * @param cell the cell the player is currently occupying
	 */
	public Player(Row row, Cell cell) {
		this.currentRow = row;
		this.currentCell = cell;
	}
	/**
	 * Returns the cell the player is currently in.
	 *
	 * @return the current Cell object
	 */
	public Cell getCurrentCell() {
		return currentCell;
	}
	/**
	 * Returns the row the player is currently in.
	 *
	 * @return the current Row object
	 */
	public Row getCurrentRow() {
		return currentRow;
	}
	/**
	 * Returns a string representation of the player.
	 *
	 * @return a string describing the player's current cell and row
	 */
	@Override
	public String toString() {
		return "Player [currentCell=" + currentCell + ", currentRow=" + currentRow + "]";
	}
	/**
	 * Sets the cell the player is currently in.
	 *
	 * @param currentCell the new cell to set for the player
	 */
	public void setCurrentCell(Cell currentCell) {
		this.currentCell = currentCell;
	}
	/**
	 * Sets the row the player is currently in.
	 *
	 * @param currentRow the new row to set for the player
	 */
	public void setCurrentRow(Row currentRow) {
		this.currentRow = currentRow;
	}

}
