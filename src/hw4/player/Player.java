package hw4.player;

import hw4.maze.Cell;
import hw4.maze.Row;

public class Player {
	
	Cell currentCell;
	Row currentRow;
	
	public Player(Row row, Cell cell) {
		this.currentRow = row;
		this.currentCell = cell;
	}

	public Cell getCurrentCell() {
		return currentCell;
	}

	public Row getCurrentRow() {
		return currentRow;
	}

	@Override
	public String toString() {
		return "Player [currentCell=" + currentCell + ", currentRow=" + currentRow + "]";
	}
	
	
	
}
