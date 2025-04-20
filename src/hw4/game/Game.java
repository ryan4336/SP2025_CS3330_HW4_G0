package hw4.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import hw4.maze.*;
import hw4.player.*;

public class Game {
	Grid grid;

	public Game(Grid grid) {
		this.grid = grid;
	}

	public Game(int i) {
		grid = createRandomGrid(i);
	}

	public Grid getGrid() {
		return grid;
	}

	public void setGrid(Grid grid) {
		this.grid = grid;
	}

	@Override
	public String toString() {
		return "Game [grid=" + grid + "]";
	}

	public boolean play(Movement direction, Player player) {
		if(direction == null || player == null) {
			return false;
		}
		Cell currentCell = player.getCurrentCell();
		Row currentRow = player.getCurrentRow();

		int rowIdx = grid.getRows().indexOf(currentRow);
		int colIdx = currentRow.getCells().indexOf(currentCell);

		int newRow = rowIdx;
		int newCol = colIdx;

		switch (direction) {
		case UP:
			if (currentCell.getUp() == CellComponents.WALL || rowIdx-1 > grid.getSize()-1) {
				System.out.println("\nERROR: Cannot move in that direction!\n");
				return false;
			}
			System.out.println("\nMoving UP...\n");
			newRow = rowIdx - 1;
			break;
		case DOWN:
			if (currentCell.getDown() == CellComponents.WALL || rowIdx+1 >= grid.getSize()){
				System.out.println("\nERROR: Cannot move in that direction!\n");
				return false;
			}
			System.out.println("\nMoving DOWN...\n");
			newRow = rowIdx + 1;
			break;
		case LEFT:
			if(currentCell.hasExit()) {
				return true;
			}
			if (currentCell.getLeft() == CellComponents.WALL || colIdx-1 >= grid.getSize()) {
				System.out.println("\nERROR: Cannot move in that direction!\n");
				return false;
			}
			System.out.println("\nMoving LEFT...\n");	
			newCol = colIdx - 1;
			break;
		case RIGHT:
			if (currentCell.getRight() == CellComponents.WALL || colIdx+1 >= grid.getSize()) {
				System.out.println("\nERROR: Cannot move in that direction!\n");
				return false;
			}
			System.out.println("\nMoving RIGHT...\n");
			newCol = colIdx + 1;
			break;
		}

		Row newPlayerRow = grid.getRows().get(newRow);
		Cell newPlayerCell = newPlayerRow.getCells().get(newCol);
		player.setCurrentRow(newPlayerRow);
		player.setCurrentCell(newPlayerCell);
		
		return true;
	}

	public Grid createRandomGrid(int gridSize) {
		if (gridSize == 0) {
			Random rand = new Random();
			gridSize = rand.nextInt(5) + 3;
		}
		if (gridSize < 3 || gridSize > 7) {
			return null;
		}

		ArrayList<Row> rows = new ArrayList<>();
		for (int i = 0; i < gridSize; i++) {
			ArrayList<Cell> cells = new ArrayList<>();
			for (int j = 0; j < gridSize; j++) {
				Cell cell = new Cell(CellComponents.WALL, CellComponents.WALL, CellComponents.WALL, CellComponents.WALL);
				cells.add(cell);
			}
			rows.add(new Row(cells));
		}

		Grid grid = new Grid(rows);
		Random rand = new Random();

		
		int exitRow = rand.nextInt(gridSize);
		grid.getRows().get(exitRow).getCells().get(0).setLeft(CellComponents.EXIT);

		
		int row = gridSize - 1;
		int col = gridSize - 1;

		while (row != exitRow || col != 0) {
			Cell current = grid.getRows().get(row).getCells().get(col);

			if (col > 0 && (row == exitRow || rand.nextBoolean())) {
				
				Cell left = grid.getRows().get(row).getCells().get(col - 1);
				current.setLeft(CellComponents.APERTURE);
				left.setRight(CellComponents.APERTURE);
				col--;
			} else if (row > 0) {
				
				Cell up = grid.getRows().get(row - 1).getCells().get(col);
				current.setUp(CellComponents.APERTURE);
				up.setDown(CellComponents.APERTURE);
				row--;
			}
		}

		
		for (int i = 0; i < gridSize; i++) {
			for (int j = 0; j < gridSize; j++) {
				Cell cell = grid.getRows().get(i).getCells().get(j);
				if (j > 0) {
					cell.setLeft(grid.getRows().get(i).getCells().get(j - 1).getRight());
				}
				if (i > 0) {
					cell.setUp(grid.getRows().get(i - 1).getCells().get(j).getDown());
				}
				if (cell.getRight() == CellComponents.WALL) {
					cell.setRight(randomWallOrAperture());
				}
				if (cell.getDown() == CellComponents.WALL) {
					cell.setDown(randomWallOrAperture());
				}

				
				if (cell.getUp() != CellComponents.APERTURE &&
					cell.getDown() != CellComponents.APERTURE &&
					cell.getLeft() != CellComponents.APERTURE &&
					cell.getRight() != CellComponents.APERTURE) {
					cell.setRight(CellComponents.APERTURE); 
				}
			}
		}

		return grid;
	}

	private static CellComponents randomWallOrAperture() {
		Random rand = new Random();
		int index = rand.nextInt(2);
		switch (index) {
		case 0:
			return CellComponents.WALL;
		case 1:
			return CellComponents.APERTURE;
		default:
			return CellComponents.APERTURE;
		}
	}
	
	public void printGrid(Grid grid, Player player) {
	    for (int rowIdx = 0; rowIdx < grid.getRows().size(); rowIdx++) {
	        Row row = grid.getRows().get(rowIdx);
	        StringBuilder sb = new StringBuilder();

	        for (int colIdx = 0; colIdx < row.getCells().size(); colIdx++) {
	            Cell cell = row.getCells().get(colIdx);

	            
	            if (player.getCurrentRow() == row && player.getCurrentCell() == cell) {
	                sb.append("A");
	            } 
	            else if (cell.getLeft() == CellComponents.EXIT || 
	                     cell.getRight() == CellComponents.EXIT ||
	                     cell.getUp() == CellComponents.EXIT ||
	                     cell.getDown() == CellComponents.EXIT) {
	                sb.append("E");
	            } 
	            else {
	                sb.append("S");
	            }
	        }

	        System.out.println(sb.toString());
	    }
	    System.out.println();
	}

}
