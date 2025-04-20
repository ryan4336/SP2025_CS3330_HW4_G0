package hw4.main;

import hw4.game.Game;
import hw4.maze.Cell;
import hw4.maze.Grid;
import hw4.maze.Row;
import hw4.player.Player;

public class Main {

	public static void main(String[] args) {
		Game game = new Game(0);
		Grid grid = game.getGrid();
		int gridSize = grid.getSize();
		
		Cell startingCell = grid.getRows().get(gridSize-1).getCells().get(gridSize-1);
        Row startingRow = grid.getRows().get(gridSize-1);
		Player player = new Player(startingRow, startingCell);
		
		game.printGrid(grid, player);
		
		ScannerInputHandler inputHandler = new ScannerInputHandler(player, game);
		inputHandler.listenForCommands();
		
		
    }

}
