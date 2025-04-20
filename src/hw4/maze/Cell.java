package hw4.maze;



public class Cell {
	CellComponents left;
	CellComponents right;
	CellComponents up;
	CellComponents down;

	public Cell(CellComponents left, CellComponents right, CellComponents up, CellComponents down) {
		this.left = left;
		this.right = right;
		this.up = up;
		this.down = down;
	}

	public CellComponents getUp() {
		return up;
	}

	public void setUp(CellComponents up) {
		if (up == null) {
			this.up = CellComponents.WALL;
			return;
		}
		this.up = up;
	}

	public CellComponents getDown() {
		return down;
	}

	public void setDown(CellComponents down) {
		if (down == null) {
			this.down = CellComponents.WALL;
			return;
		}
		this.down = down;
	}

	public CellComponents getLeft() {
		return left;
	}

	public void setLeft(CellComponents left) {
		if (left == null) {
			this.left = CellComponents.WALL;
			return;
		}
		this.left = left;
	}

	public CellComponents getRight() {
		return right;
	}

	public void setRight(CellComponents right) {
		if (right == null) {
			this.right = CellComponents.WALL;
			return;
		}
		this.right = right;
	}

	@Override
	public String toString() {
		return "Cell [left=" + left + ", right=" + right + ", up=" + up + ", down=" + down + "]";
	}
	
	public boolean hasExit() {
		if(this.left == CellComponents.EXIT) {
			return true;
		}
		return false;
	}

}
