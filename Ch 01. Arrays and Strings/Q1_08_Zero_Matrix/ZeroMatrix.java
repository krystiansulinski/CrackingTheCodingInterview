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
        final HashSet<Integer> columnsToZero = new HashSet<>();

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (columnsToZero.contains(col)) {
                    matrix[row][col] = 0;
                }
                if (matrix[row][col] == 0) {
                    zeroRow(matrix, row);
                    columnsToZero.add(col);
                }
            }
        }

        return true;
    }

    public static boolean zeroRow(int[][] matrix, final int row) {
        if (row < 0 || row >= matrix.length || matrix[row].length < 2) {
            return false;
        }

        for (int col = 0; col < matrix[row].length; col++) {
            matrix[row][col] = 0;
        }

        return true;
    }
}