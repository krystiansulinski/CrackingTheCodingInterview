/* 1.7 Rotate Matrix
 * Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes,
 * write a method to rotate the image by 90 degrees. Can you do this in place?
 */
package Q1_07_Rotate_Matrix;

public class RotateMatrix {
    public static void rotateMarix(int[][] arr) {
        final int N = arr.length;
        for (int i = 0; i < N; i++) {
            if (arr[i].length != N) {
                return;
            }
        }

        while (true) {
        }
    }

    public void rotate(int[][] arr, int rowIdxFrom, int colIdxFrom) {
        int N = arr.length;
        int maxIndex = N - 1;

        int temp;
        for (int i = 0; i < 4; i++) {
            int value = arr[]
            int rowIdxTo = rowIdxFrom;
            int colIdxTo = colIdxFrom;
            boolean isLastRow = rowIdxTo == maxIndex;
            boolean isLastCol = colIdxTo == maxIndex;

            for (int j = 0; j < maxIndex; j++) {
                if (colIdxTo < maxIndex) {
                    colIdxTo++;
                } else if (rowIdxTo < maxIndex) {
                    rowIdxTo++;
                } else if (isLastRow && isLastCol) {
                    colIdxTo--;
                } else if (isLastRow && !isLastCol) {
                    rowIdxTo--;
                } else if (!isLastRow && isLastCol) {
                    rowIdxTo++;
                }
            }

            temp = arr[rowIdxTo][colIdxTo];
            arr[rowIdxTo][colIdxTo] = arr[rowIdxFrom][colIdxFrom];
        }
    }

    public int[] getNextIndeces(int rowIdx, int colIdx, int length) {
        int[][] indeces = new int[1][1];
        int lastIndex = length - 1;

        boolean reachLastRow = rowIdx == lastIndex;
        boolean reachedLastCol = colIdx == lastIndex;

        for (int i = 0; i < lastIndex; i++) {
            for (int j = 0; j < lastIndex; j++) {

            }
        }

        return indeces;
    }
}
