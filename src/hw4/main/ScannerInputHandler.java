package hw4.main;

import java.util.Scanner;

import hw4.game.Game;
import hw4.player.Movement;
import hw4.player.Player;

public class ScannerInputHandler {
	private final Scanner scanner;
    private final Player player;
    private final Game game;

    public ScannerInputHandler(Player player, Game game) {
        this.scanner = new Scanner(System.in);
        this.player = player;
        this.game = game;
    }

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
