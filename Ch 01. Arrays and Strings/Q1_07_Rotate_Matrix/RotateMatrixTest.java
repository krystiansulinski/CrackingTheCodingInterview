package Q1_07_Rotate_Matrix;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class RotateMatrixTest {
    final int[][] arr2D = {
            {1, 2},
            {3, 4}
    };

    final int[][] rotated2D = {
            {3, 1},
            {4, 2}
    };

    final int[][] arr3D = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
    };

    final int[][] rotated3D = {
            {7, 4, 1},
            {8, 5, 2},
            {9, 6, 3}
    };

    final int[][] arr4D = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
    };

    final int[][] rotated4D = {
            {13, 9, 5, 1},
            {14, 10, 6, 2},
            {15, 11, 7, 3},
            {16, 12, 8, 4}
    };

    @Test
    public void rotate2DMatrix() {
        assertArrayEquals(rotated2D, RotateMatrix.rotateRight(arr2D));
    }

    @Test
    public void rotate3DMatrix() {
        assertArrayEquals(rotated3D, RotateMatrix.rotateRight(arr3D));
    }

    @Test
    public void rotate4DMatrix() {
        assertArrayEquals(rotated4D, RotateMatrix.rotateRight(arr4D));
    }

    @Test
    public void rotate2DMatrixInPlace() {
        System.out.println(printMatrix(arr2D));
        RotateMatrix.rotateRightInPlace(arr2D);
        System.out.println(printMatrix(arr2D));

        assertArrayEquals(rotated2D, arr2D);
    }

    @Test
    public void rotate3DMatrixInPlace() {
        System.out.println(printMatrix(arr3D));
        RotateMatrix.rotateRightInPlace(arr3D);
        System.out.println(printMatrix(arr3D));

        assertArrayEquals(rotated3D, arr3D);
    }

    @Test
    public void rotate4DMatrixInPlace() {
        System.out.println(printMatrix(arr4D));
        RotateMatrix.rotateRightInPlace(arr4D);
        System.out.println(printMatrix(arr4D));

        assertArrayEquals(rotated4D, arr4D);
    }

    public String printMatrix(int[][] mat) {
        final StringBuilder sb = new StringBuilder();

        for (int row = 0; row < mat.length; row++) {
            for (int col = 0; col < mat[row].length; col++) {
                sb.append(mat[row][col]).append(' ');
            }
            sb.append('\n');
        }

        return sb.toString();
    }
}