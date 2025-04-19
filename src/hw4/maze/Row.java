package hw4.maze;

import java.util.ArrayList;

public class Row {
	ArrayList<Cell> cells;

	public Row(ArrayList<Cell> cells) {
		this.cells = cells;
	}

	public ArrayList<Cell> getCells() {
		return cells;
	}

	public void setCells(ArrayList<Cell> cells) {
		this.cells = cells;
	}
	
	public Cell getCell(int i) {
		return cells.get(i);
	}

	@Override
	public String toString() {
		return "Row [cells=" + cells + "]";
	}
	
	
	
}

	