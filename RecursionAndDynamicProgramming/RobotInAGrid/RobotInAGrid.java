/*
 * 8.2 Robot in a Grid
 * 
 * Imagine a robot sitting on the upper left corner of grid with r rows and c columns.
 * The robot can only move in two directions, right and down, but certain cells are "off limits" such that
 * the robot cannot step on them. Design an algorithm to find a path for the robot from the top left 
 * to the bottom right.
 */

package RobotInAGrid;

public class RobotInAGrid {
	public static int[][] findPath(int rows, int cols) {
		int[][] grid = generateGrid(rows, cols, 0.8);

		printGrid(grid);
		grid = findPath(grid, 0, 0);
		printGrid(grid);

		grid = findPathBack(grid, rows - 1, cols - 1);
		printGrid(grid);

//      TODO: fix the loop to print turns
//		List<String> path = new ArrayList<>();
//		int col = 0;
//		int row = 0;
//		do {
//			if (grid[row][col + 1] == 2) {
//				path.add("right");
//				col++;
//			} else if (grid[row + 1][col] == 2) {
//				path.add("down");
//				row++;
//			} else {
//				break;
//			}
//		} while (true);

//		System.out.println(path);

		return grid;
	}

	private static int[][] findPath(int[][] grid, int row, int col) {
		int rows = grid.length;
		int cols = grid[0].length;

		if (row == rows - 1 && col == cols - 1) {
			grid[row][col] = 1;
			return grid;
		}

		boolean canGoRight = col + 1 < cols && grid[row][col + 1] <= 1;
		boolean canGoDown = row + 1 < rows && grid[row + 1][col] <= 1;

		grid[row][col] = 1;
		if (canGoRight) {
			findPath(grid, row, col + 1);
		}
		if (canGoDown) {
			findPath(grid, row + 1, col);
		}

		return grid;
	}

	private static int[][] findPathBack(int[][] grid, int row, int col) {
		if (row == 0 && col == 0) {
			grid[row][col] = 2;
			return grid;
		}

		boolean canGoLeft = col > 0 && grid[row][col - 1] == 1;
		boolean canGoUp = row > 0 && grid[row - 1][col] == 1;

		grid[row][col] = 2;
		if (canGoLeft) {
			findPathBack(grid, row, col - 1);
		} else if (canGoUp) {
			findPathBack(grid, row - 1, col);
		}
		return grid;
	}

	private static int[][] generateGrid(int rows, int cols, double probability) {
		int[][] grid = new int[rows][cols];

		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				int value = Math.random() < probability ? 0 : 8;
				if (r == 0 && c == 0 || r == rows - 1 && c == cols - 1) {
					continue;
				}
				grid[r][c] = value;
			}
		}

		return grid;
	}

	private static void printGrid(int[][] grid) {
		StringBuffer s = new StringBuffer();
		for (int[] row : grid) {
			for (int col : row) {
				s.append(col + " ");
			}
			s.append("\n");
		}
		System.out.println(s);
	}

}
