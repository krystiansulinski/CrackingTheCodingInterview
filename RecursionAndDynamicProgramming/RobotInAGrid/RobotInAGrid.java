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
		int[][] gridRecursive = Helper.generateGridWithRandomOffSpots(rows, cols, 0.8);
		int[][] gridIterative = new int[rows][cols];
		System.arraycopy(gridRecursive, 0, gridIterative, 0, rows);

		gridRecursive = findPath(gridRecursive, 0, 0);

		System.out.println(
				"Legend:\n0 - available cells\n1 - path\n2 - detected off spot\n8 - off limits cells\n");

		Helper.print(gridIterative);

		return gridRecursive;
	}

	// Move the robot down or left to 0 and rename the spot to 1. If hasn't reached
	// the bottom right, go back and mark the spot as 2.
	private static int[][] findPath(int[][] grid, int row, int col) {
		grid[row][col] = 1;

		int rows = grid.length;
		int cols = grid[0].length;
		boolean isBottomRight = row == rows - 1 && col == cols - 1;
		boolean canGoRight = col + 1 < cols && grid[row][col + 1] == 0;
		boolean canGoDown = row + 1 < rows && grid[row + 1][col] == 0;
		boolean canGoLeft = col > 0 && grid[row][col - 1] == 1;
		boolean canGoUp = row > 0 && grid[row - 1][col] == 1;

		if (isBottomRight) {
			return grid;
		} else if (canGoRight) {
			findPath(grid, row, col + 1);
		} else if (canGoDown) {
			findPath(grid, row + 1, col);
		} else if (canGoLeft) {
			grid[row][col] = 2;
			findPath(grid, row, col - 1);
		} else if (canGoUp) {
			grid[row][col] = 2;
			findPath(grid, row - 1, col);
		}
		return grid;
	}

	static class Helper {
		private static void print(int[][] grid) {
			StringBuffer path = printPath(grid, 0, 0, new StringBuffer());
			System.out.println(
					"Path: " + (path.length() == 0 ? "No path exists." : path.toString()) + "\n");
			printGrid(grid);
		}

		private static StringBuffer printPath(int[][] grid, int row, int col, StringBuffer str) {
			int rows = grid.length;
			int cols = grid[0].length;

			boolean isBottomRight = row == rows - 1 && col == cols - 1;
			boolean canGoRight = col + 1 < cols && grid[row][col + 1] == 1;
			boolean canGoDown = row + 1 < rows && grid[row + 1][col] == 1;

			if (isBottomRight) {
				return str;
			} else if (canGoRight) {
				str.append("right ");
				printPath(grid, row, col + 1, str);
			} else if (canGoDown) {
				str.append("down ");
				printPath(grid, row + 1, col, str);
			}
			return str;
		}

		private static int[][] generateGridWithRandomOffSpots(int rows, int cols,
				double probability) {
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
}
