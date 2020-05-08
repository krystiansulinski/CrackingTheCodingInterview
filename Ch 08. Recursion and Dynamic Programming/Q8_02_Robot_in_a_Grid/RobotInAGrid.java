/*
 * 8.2 Robot in a Grid
 * 
 * Imagine a robot sitting on the upper left corner of grid with r rows and c columns.
 * The robot can only move in two directions, right and down, but certain cells are "off limits" such that
 * the robot cannot step on them. Design an algorithm to find a path for the robot from the top left 
 * to the bottom right.
 */

package Q8_02_Robot_in_a_Grid;

import java.awt.*;
import java.util.ArrayList;

public class RobotInAGrid {
	public static ArrayList<Point> getPath(int rows, int cols) {
        boolean[][] grid = Helper.generateRandomGrid(rows, cols, 0.8);
        System.out.println(Helper.toString(grid));

        ArrayList<Point> path = new ArrayList<>();
        if (getPath(grid, grid.length - 1, grid[0].length - 1, path)) {
            System.out.println(Helper.getPrintedPath(path).toString());
            return path;
        }
        System.out.println("No path");
        return null;
    }

	public static boolean getPath(boolean[][] grid, int row, int col, ArrayList<Point> path) {
		if (col < 0 || row < 0 || !grid[row][col]) {
			return false;
		}

		boolean isAtOrigin = (row == 0) && (col == 0);

		if (isAtOrigin || getPath(grid, row, col - 1, path) || getPath(grid, row - 1, col, path)) {
			path.add(new Point(row, col));
			return true;
		}

		return false;
	}

	static class Helper {
		private static boolean[][] generateRandomGrid(int rows, int cols, double probability) {
			boolean[][] grid = new boolean[rows][cols];

			for (int r = 0; r < rows; r++) {
				for (int c = 0; c < cols; c++) {
                    if (r == 1 && c == 1 || r == rows - 1 && c == cols - 1) {
                        grid[r][c] = true;
                    }
                    grid[r][c] = Math.random() < probability;
                }
            }

            return grid;
        }

        public static StringBuilder getPrintedPath(ArrayList<Point> path) {
            StringBuilder str = new StringBuilder();
            for (int point = 0; point < path.size(); point++) {
                str.append(path.get(point).x + ", " + path.get(point).y + "\n");
            }
            return str;
        }

        private static StringBuffer toString(boolean[][] grid) {
            StringBuffer s = new StringBuffer();
            for (int row = 0; row < grid.length; row++) {
                for (int col = 0; col < grid[row].length; col++) {
					s.append((grid[row][col] ? 1 : 0) + " ");
				}
				s.append("\n");
			}
			return s;
		}
	}
}
