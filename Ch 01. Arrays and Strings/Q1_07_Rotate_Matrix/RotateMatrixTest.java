package Q1_07_Rotate_Matrix;

import org.junit.Test;

import java.util.Arrays;

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
        RotateMatrix.rotateRightInPlace(arr2D);
        System.out.println(Arrays.deepToString(rotated2D));
        System.out.println(Arrays.deepToString(arr2D));

        assertArrayEquals(rotated2D, arr2D);
    }

    @Test
    public void rotate3DMatrixInPlace() {
        RotateMatrix.rotateRightInPlace(arr3D);
        System.out.println(Arrays.deepToString(rotated3D));
        System.out.println(Arrays.deepToString(arr3D));

        assertArrayEquals(rotated3D, arr3D);
    }

    @Test
    public void rotate4DMatrixInPlace() {
        RotateMatrix.rotateRightInPlace(arr4D);
        System.out.println(Arrays.deepToString(rotated4D));
        System.out.println(Arrays.deepToString(arr4D));

        assertArrayEquals(rotated4D, arr4D);
    }
}