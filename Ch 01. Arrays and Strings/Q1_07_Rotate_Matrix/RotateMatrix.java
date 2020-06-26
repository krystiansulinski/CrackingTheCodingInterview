package Q1_07_Rotate_Matrix;

public class RotateMatrix {
    public static void rotateMarix(int[][] arr) {
        final int N = arr.length;
        for (int i = 0; i < N; i++) {
            if (arr[i].length != N) {
                return;
            }
        }

        int rotation = 0;
        int rowOld = 0;
        int colOld = 0;
        while (rotation < N) {
            int increments = 0;
            int row = rowOld;
            int col = colOld;
            boolean increase = row != N - 1 && col != N - 1;
            while (increments < N) {
                if (increase) {
                    if (row < N - 1) {
                        row++;
                    } else if (col < N - 1) {
                        col++;
                    }
                } else {
                    if (row > 0) {
                        row--;
                    } else if (col > 0) {
                        col--;
                    }
                }
                increments++;
            }
            // TODO: revisit temp
            int temp = arr[row][col];
            arr[row][col] = arr[rowOld][colOld];

            rotation++;
        }
    }

    public void rotate(int[][] arr, int row, int col) {
        int N = arr.length;
        for (int i = 0; i < 4; i++) {
            int rowTo = row;
            int colTo = col;
            boolean lastRow = rowTo == N - 1;
            boolean lastCol = colTo == N - 1;

            for (int j = 0; j < N; j++) {
                if (colTo < N - 1) {
                    colTo++;
                } else if (rowTo < N - 1) {
                    rowTo++;
                } else if (lastCol && !lastRow) {
                    rowTo++;
                } else if (lastRow && !lastCol) {
                    rowTo--;
                } else if (lastCol && lastRow) {
                    colTo--;
                }
            }
        }
    }
}
