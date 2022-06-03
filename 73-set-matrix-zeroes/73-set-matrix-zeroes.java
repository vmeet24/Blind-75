class Solution {
    public void setZeroes(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    setZero(i, j, matrix);
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == Integer.MAX_VALUE + 2) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    private void setZero(int row, int col, int[][] matrix) {
        for (int i = row; i >= 0; i--) {
            if (matrix[i][col] != 0)
                matrix[i][col] = Integer.MAX_VALUE + 2;
        }
        for (int i = row; i < matrix.length; i++) {
            if (matrix[i][col] != 0)
                matrix[i][col] = Integer.MAX_VALUE + 2;
        }
        for (int i = col; i >= 0; i--) {
            if (matrix[row][i] != 0)
                matrix[row][i] = Integer.MAX_VALUE + 2;
        }
        for (int i = col; i < matrix[0].length; i++) {
            if (matrix[row][i] != 0)
                matrix[row][i] = Integer.MAX_VALUE + 2;
        }
    }
}