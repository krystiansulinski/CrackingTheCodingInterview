/* 1.8 Zero Matrix: Write an algorithm such that if an element in an MxN matrix is 0,
 * its entire row and column are set to 0.
 */
package Q1_08_Zero_Matrix;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ZeroMatrix {
    public static void zeroMatrixInPlace(final int[][] matrix) {
        markZeroRowsAndCols(matrix);
        replacedMarkedRowsAndColsWithZeros(matrix);
    }

    public static void markZeroRowsAndCols(final int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                final int value = matrix[row][col];
                if (value == 0) {
                    markRow(matrix, row);
                    markCol(matrix, col);
                }
            }
        }
    }

    public static void markRow(final int[][] matrix, final int row) {
        for (int col = 0; col < matrix[row].length; col++) {
            if (matrix[row][col] != 0) {
                matrix[row][col] = Integer.MIN_VALUE;
            }
        }
    }

    public static void markCol(final int[][] matrix, final int col) {
        for (int row = 0; row < matrix.length; row++) {
            if (col < matrix[row].length && matrix[row][col] != 0) {
                matrix[row][col] = Integer.MIN_VALUE;
            }
        }
    }

    public static void replacedMarkedRowsAndColsWithZeros(final int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == Integer.MIN_VALUE) {
                    matrix[row][col] = 0;
                }
            }
        }
    }

    public static void zeroMatrix(final int[][] matrix) {
        if (matrix.length == 0) {
            return;
        }

        /* Count occurrences and don't zero rows and cols that are already filled with zeroes only */
        final Map<Integer, Integer> rows = new HashMap<>();
        final Map<Integer, Integer> cols = new HashMap<>();

        for (int row = 0; row < matrix.length; row++) {
            final int colLength = matrix[row].length;
            int col = 0;
            for (; col < colLength; col++) {
                if (matrix[row][col] == 0) {
                    rows.put(row, rows.containsKey(row) ? rows.get(row) + 1 : 1);
                    cols.put(col, cols.containsKey(col) ? cols.get(col) + 1 : 1);
                }
            }

            final boolean isZeroRow = rows.containsKey(row) && rows.get(row) == colLength;
            if (isZeroRow) {
                zeroAll(matrix);
                return;
            }
        }

        for (final int col : cols.keySet()) {
            final boolean isZeroCol = cols.get(col) == matrix.length;
            if (isZeroCol) {
                zeroAll(matrix);
                return;
            }
        }

        zeroRows(matrix, rows.keySet());
        zeroCols(matrix, cols.keySet());
    }

    public static void zeroAll(final int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = 0;
            }
        }
    }

    public static void zeroRows(final int[][] matrix, final Set<Integer> rows) {
        for (final int row : rows) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = 0;
            }
        }
    }

    public static void zeroCols(final int[][] matrix, final Set<Integer> cols) {
        for (final int col : cols) {
            for (int row = 0; row < matrix.length; row++) {
                if (col < matrix[row].length) {
                    matrix[row][col] = 0;
                }
            }
        }
    }
}