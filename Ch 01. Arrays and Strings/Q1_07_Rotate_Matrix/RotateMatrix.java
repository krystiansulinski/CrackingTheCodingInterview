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

    public static void rotateRightInPlace(int[][] arr) {
        // assume arr is NxN
        // assume values in arr are different
        final int N = arr.length;
        final int maxIdx = N - 1;

        for (int col = 0; col < N / 2; col++) {
            for (int row = 0; row < N; row++) {
                int temp = arr[col][maxIdx - row];
                arr[col][maxIdx - row] = arr[row][col];
                arr[row][col] = temp;

                temp = arr[maxIdx - row][maxIdx - col];
                arr[maxIdx - row][maxIdx - col] = arr[row][col];
                arr[row][col] = temp;

                temp = arr[maxIdx - col][row];
                arr[maxIdx - col][row] = arr[row][col];
                arr[row][col] = temp;

                temp = arr[maxIdx - col][row];
                arr[maxIdx - col][row] = arr[row][col];
                arr[row][col] = temp;
            }
        }
    }

    public static void swap(int[][] arr, final int oldRow, final int oldCol, final int newRow, final int newCol) {
//        final int temp = arr[col][N - row];
//        arr[col][maxIdx - row] = arr[row][col];
//        arr[row][col] = temp;
    }
}
