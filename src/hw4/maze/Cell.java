package hw4.maze;


/**
 * Represents a cell within the grid-based maze game.
 * Each cell has four directional components (left, right, up, down)
 * that can be either a WALL, APERTURE, or EXIT.
 */
public class Cell {
	private CellComponents left;
	private CellComponents right;
	private CellComponents up;
	private CellComponents down;
	/**
	 * Constructs a Cell with specified components on each side.
	 * 
	 * @param left  the component on the left side
	 * @param right the component on the right side
	 * @param up    the component on the top side
	 * @param down  the component on the bottom side
	 */
	public Cell(CellComponents left, CellComponents right, CellComponents up, CellComponents down) {
		this.left = left;
		this.right = right;
		this.up = up;
		this.down = down;
	}
	/**
	 * Returns the component on the top side.
	 * 
	 * @return the up component
	 */
	public CellComponents getUp() {
		return up;
	}
	/**
	 * Sets the component on the top side.
	 * If null is provided, it defaults to WALL.
	 * 
	 * @param up the new up component
	 */
	public void setUp(CellComponents up) {
		if (up == null) {
			this.up = CellComponents.WALL;
			return;
		}
		this.up = up;
	}
	/**
	 * Returns the component on the bottom side.
	 * 
	 * @return the down component
	 */
	public CellComponents getDown() {
		return down;
	}
	/**
	 * Sets the component on the bottom side.
	 * If null is provided, it defaults to WALL.
	 * 
	 * @param down the new down component
	 */
	public void setDown(CellComponents down) {
		if (down == null) {
			this.down = CellComponents.WALL;
			return;
		}
		this.down = down;
	}
	/**
	 * Returns the component on the left side.
	 * 
	 * @return the left component
	 */
	public CellComponents getLeft() {
		return left;
	}
	/**
	 * Sets the component on the left side.
	 * If null is provided, it defaults to WALL.
	 * 
	 * @param left the new left component
	 */
	public void setLeft(CellComponents left) {
		if (left == null) {
			this.left = CellComponents.WALL;
			return;
		}
		this.left = left;
	}
	/**
	 * Returns the component on the right side.
	 * 
	 * @return the right component
	 */
	public CellComponents getRight() {
		return right;
	}
	/**
	 * Sets the component on the right side.
	 * If null is provided, it defaults to WALL.
	 * 
	 * @param right the new right component
	 */
	public void setRight(CellComponents right) {
		if (right == null) {
			this.right = CellComponents.WALL;
			return;
		}
		this.right = right;
	}
	/**
	 * Returns a string representation of the cell and its components.
	 * 
	 * @return string containing the components of the cell
	 */
	@Override
	public String toString() {
		return "Cell [left=" + left + ", right=" + right + ", up=" + up + ", down=" + down + "]";
	}
	/**
	 * Checks if this cell has an EXIT on its left side.
	 * 
	 * @return true if left side is an EXIT, false otherwise
	 */
	public boolean hasExit() {
		if(this.left == CellComponents.EXIT) {
			return true;
		}
		return false;
	}

}
