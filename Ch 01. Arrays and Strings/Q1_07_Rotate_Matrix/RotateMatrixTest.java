package Q1_07_Rotate_Matrix;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class RotateMatrixTest {
    @Test
    public void rotate2DMatrix() {
        final int[][] arr = {
                {1, 2},
                {3, 4}
        };

        final int[][] rotated = {
                {3, 1},
                {4, 2}
        };

        assertArrayEquals(rotated, RotateMatrix.rotateRightBy90Degrees(arr));
    }

    @Test
    public void rotate3DMatrix() {
        final int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        final int[][] rotated = {
                {7, 4, 1},
                {8, 5, 2},
                {9, 6, 3}
        };

        assertArrayEquals(rotated, RotateMatrix.rotateRightBy90Degrees(arr));
    }

    @Test
    public void rotate4DMatrix() {
        final int[][] arr = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        final int[][] rotated = {
                {13, 9, 5, 1},
                {14, 10, 6, 2},
                {15, 11, 7, 3},
                {16, 12, 8, 4}
        };

        assertArrayEquals(rotated, RotateMatrix.rotateRightBy90Degrees(arr));
    }
}