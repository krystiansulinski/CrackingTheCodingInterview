package Q1_08_Zero_Matrix;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class ZeroMatrixTest {
    final int[][] arr2D = {
            {0, 2},
            {3, 4}
    };

    final int[][] zero2D = {
            {0, 0},
            {0, 4}
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

    final int[][] zero4D = {
            {0, 0, 0, 0},
            {0, 6, 7, 0},
            {0, 10, 11, 0},
            {0, 0, 0, 0}
    };

    @Test
    public void zeroMatrix2D() {
        ZeroMatrix.zeroMatrix(arr2D);
        assertArrayEquals(zero2D, arr2D);
    }

    @Test
    public void zeroMatrix3D() {
        ZeroMatrix.zeroMatrix(arr3D);
        assertArrayEquals(zero3D, arr3D);
    }

    @Test
    public void zeroMatrix4D() {
        ZeroMatrix.zeroMatrix(arr4D);
        assertArrayEquals(zero4D, arr4D);
    }
}