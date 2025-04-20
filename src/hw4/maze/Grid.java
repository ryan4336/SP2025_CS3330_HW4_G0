package hw4.maze;

import java.util.ArrayList;

public class Grid {
	ArrayList<Row> rows;

	public Grid(ArrayList<Row> rows) {
		this.rows = rows;
	}

	public ArrayList<Row> getRows() {
		return rows;
	}

	public void setRows(ArrayList<Row> rows) {
		this.rows = rows;
	}
	
	public int getSize() {
		return rows.size();
	}
	@Override
	public String toString() {
		return "Grid [rows=" + rows + "]";
	}

}
