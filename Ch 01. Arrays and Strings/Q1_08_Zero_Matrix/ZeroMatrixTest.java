package Q1_08_Zero_Matrix;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class ZeroMatrixTest {
    final int[][] matrix2x1 = {
            {0, 2},
            {3}
    };

    final int[][] matrix2x1Zero = {
            {0, 0},
            {0}
    };

    final int[][] matrix3D = {
            {0, 2, 3},
            {4, 0, 6},
            {7, 8, 0}
    };

    final int[][] matrix3DZero = {
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0}
    };

    final int[][] matrix3x2a = {
            {0, 2, 3},
            {0, 1, 6},
            {0, 8, 2}
    };

    final int[][] matrix3x2aZero = {
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0}
    };

    final int[][] matrix3x2b = {
            {0, 0, 0},
            {4, 5, 6},
            {7, 8, 9}
    };

    final int[][] matrix3x2bZero = {
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0}
    };

    final int[][] matrix4D = {
            {0, 2, 3, 0},
            {5, 6},
            {9, 10, 11, 12},
            {13, 14, 0}
    };

    final int[][] matrix4DZero = {
            {0, 0, 0, 0},
            {0, 6},
            {0, 10, 0, 0},
            {0, 0, 0}
    };

    @Test
    public void zeroMatrix2D() {
        ZeroMatrix.zeroMatrix(matrix2x1);
        assertArrayEquals(matrix2x1Zero, matrix2x1);
    }

    @Test
    public void zeroMatrix3D() {
        ZeroMatrix.zeroMatrix(matrix3D);
        assertArrayEquals(matrix3DZero, matrix3D);
    }

    @Test
    public void zeroMatrix3x2a() {
        ZeroMatrix.zeroMatrix(matrix3x2a);
        assertArrayEquals(matrix3x2aZero, matrix3x2a);
    }

    @Test
    public void zeroMatrix3x2b() {
        ZeroMatrix.zeroMatrix(matrix3x2b);
        assertArrayEquals(matrix3x2bZero, matrix3x2b);
    }

    @Test
    public void zeroMatrix4D() {
        ZeroMatrix.zeroMatrix(matrix4D);
        assertArrayEquals(matrix4DZero, matrix4D);
    }

    @Test
    public void zeroMatrix2DInPlace() {
        ZeroMatrix.zeroMatrixInPlace(matrix2x1);
        assertArrayEquals(matrix2x1Zero, matrix2x1);
    }

    @Test
    public void zeroMatrix3DInPlace() {
        ZeroMatrix.zeroMatrixInPlace(matrix3D);
        assertArrayEquals(matrix3DZero, matrix3D);
    }

    @Test
    public void zeroMatrix3x2aInPlace() {
        ZeroMatrix.zeroMatrixInPlace(matrix3x2a);
        assertArrayEquals(matrix3x2aZero, matrix3x2a);
    }

    @Test
    public void zeroMatrix3x2bInPlace() {
        ZeroMatrix.zeroMatrixInPlace(matrix3x2b);
        assertArrayEquals(matrix3x2bZero, matrix3x2b);
    }

    @Test
    public void zeroMatrix4DInPlace() {
        ZeroMatrix.zeroMatrixInPlace(matrix4D);
        assertArrayEquals(matrix4DZero, matrix4D);
    }
}