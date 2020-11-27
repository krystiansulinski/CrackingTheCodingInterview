/* 1.8 Zero Matrix: Write an algorithm such that if an element in an MxN matrix is 0,
 * its entire row and column are set to 0.
 */
package Q1_08_Zero_Matrix;

import java.util.HashSet;

public class ZeroMatrix {
    public static boolean zeroMatrix(int[][] matrix) {
        if (matrix.length == 0) {
            return false;
        }

        final HashSet<Integer> rows = new HashSet<>();
        final HashSet<Integer> cols = new HashSet<>();

        // Test
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 0) {
                    rows.add(row);
                    cols.add(col);
                }
            }
        }

        for (final int row : rows) {
            zeroRow(matrix, row);
        }

        for (final int col : cols) {
            zeroCol(matrix, col, rows);
        }

        return true;
    }

    public static void zeroRow(int[][] matrix, final int row) {
        if (row < 0 || row >= matrix.length || matrix[row].length == 1) {
            return;
        }

        for (int col = 0; col < matrix[row].length; col++) {
            matrix[row][col] = 0;
        }
    }

    public static void zeroCol(int[][] matrix, final int col, final HashSet<Integer> zeroedRows) {
        if (col < 0) {
            return;
        }

        for (int row = 0; row < matrix.length; row++) {
            final int rowLength = matrix[row].length;
            final boolean isNotZeroRow = !zeroedRows.contains(row);

            if (rowLength > 1 && col < rowLength && isNotZeroRow) {
                matrix[row][col] = 0;
            }
        }
    }
}