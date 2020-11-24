/* 1.7 Rotate Matrix
 * Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes,
 * write a method to rotate the image by 90 degrees. Can you do this in place?
 */
package Q1_07_Rotate_Matrix;

public class RotateMatrix {
    public static int[][] rotateRight(final int[][] arr) {
        // assume arr is NxN
        // assume values in arr are different
        final int N = arr.length;
        int[][] rotated = new int[N][N];

        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                rotated[row][col] = arr[N - 1 - col][row];
            }
        }

        return rotated;
    }

    public static boolean rotateRightInPlace(int[][] matrix) {
        if (matrix.length == 0 || matrix.length != matrix[0].length) {
            return false;
        }

        final int n = matrix.length;

        for (int layer = 0; layer < n / 2; layer++) {
            final int first = layer;
            final int last = n - 1 - layer;
            for (int i = first; i < last; i++) {
                final int offset = i - first;

                final int top = matrix[first][i]; // save top

                // left -> top
                matrix[first][i] = matrix[last - offset][first];

                // bottom -> left
                matrix[last - offset][first] = matrix[last][last - offset];

                // right -> bottom
                matrix[last][last - offset] = matrix[i][last];

                // top -> right
                matrix[i][last] = top;
            }
        }

        return true;
    }
}
