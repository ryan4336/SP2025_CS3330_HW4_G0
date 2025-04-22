package hw4.main;

import java.util.Scanner;

import hw4.game.Game;
import hw4.player.Movement;
import hw4.player.Player;
/**
 * Handles user input from the console for controlling the player in the game.
 * Accepts movement commands and communicates with the Game and Player objects
 * to execute those commands.
 */
public class ScannerInputHandler {
	private final Scanner scanner;
    private final Player player;
    private final Game game;
    /**
     * Constructs a new ScannerInputHandler with the specified player and game.
     *
     * @param player the player object whose position is controlled by user input
     * @param game the game object used to process player movements and game logic
     */
    public ScannerInputHandler(Player player, Game game) {
        this.scanner = new Scanner(System.in);
        this.player = player;
        this.game = game;
    }
    /**
     * Starts an input loop that listens for movement commands from the user.
     * Valid commands are "up", "down", "left", "right", and "exit".
     * Movement commands are passed to the game logic to move the player.
     * If the player reaches the exit, the game prints a win message and exits.
     */
    public void listenForCommands() {
    	
        while (true) {
        	if(player.getCurrentCell().hasExit()) {
        		game.play(Movement.LEFT, player);
            	System.out.println("Congratulations, you have won!");
            	System.out.println("Exiting program...");
            	System.exit(0);
            }
        	
            System.out.print("Enter direction (Up, Down, Left, Right) or 'exit' to quit: ");
            String input = scanner.nextLine().trim().toLowerCase();
            
            switch (input) {
                case "up":
                    game.play(Movement.UP, player);
                    break;
                case "down":
                	game.play(Movement.DOWN, player);
                    break;
                case "left":
                	game.play(Movement.LEFT, player);
                    break;
                case "right":
                	game.play(Movement.RIGHT, player);
                    break;
                case "exit":
                    System.out.println("Exiting game...");
                    return;
                default:
                    System.out.println("\nInvalid input. Try again.\n");
            }

            game.printGrid(game.getGrid(), player);
        }
    }
}
