package hw4.maze;
/**
 * Defines the types of components that can exist on the sides of a Cell.
 * These components determine the cell's connectivity and behavior.
 */
public enum CellComponents {
	/**
     * Represents a solid wall; movement is blocked.
     */
    WALL,
    /**
     * Represents a passable opening; movement is allowed.
     */
    APERTURE,
    /**
     * Represents the maze's exit; reaching it ends the game.
     */
    EXIT
}
