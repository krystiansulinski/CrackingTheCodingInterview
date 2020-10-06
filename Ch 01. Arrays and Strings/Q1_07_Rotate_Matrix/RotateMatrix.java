/* 1.7 Rotate Matrix
 * Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes,
 * write a method to rotate the image by 90 degrees. Can you do this in place?
 */
package Q1_07_Rotate_Matrix;

public class RotateMatrix {
    public static int[][] rotateRightBy90Degrees(final int[][] arr) {
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
}
