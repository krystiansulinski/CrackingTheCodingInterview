package Q1_07_Rotate_Matrix;

import Q1_08_Zero_Matrix.ZeroMatrix;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class ZeroMatrixTest {
    final int[][] arr2D = {
            {0, 2},
            {3, 4}
    };

    final int[][] zero2D = {
            {0, 0},
            {0, 2}
    };

    final int[][] arr3D = {
            {0, 2, 3},
            {4, 0, 6},
            {7, 8, 0}
    };

    final int[][] zero3D = {
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0}
    };

    final int[][] arr4D = {
            {0, 2, 3, 0},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 0}
    };

    final int[][] rotated4D = {
            {0, 0, 0, 0},
            {14, 10, 6, 0},
            {15, 11, 7, 0},
            {16, 12, 8, 0}
    };

    @Test
    public void zeroMatrix() {
        ZeroMatrix.zeroMatrix(arr2D);
        assertArrayEquals(zero2D, arr2D);
    }
}