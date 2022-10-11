class Solution {

    public void solve(char[][] board) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        int[] deltaRow = { 0, -1, 0, +1 };
        int[] deltaCol = { -1, 0, +1, 0 };

        // first col and last col
        for (int i = 0; i < visited.length; i++) {
            if (board[i][0] == 'O' && !visited[i][0]) {
                dfs(i, 0, board, visited, deltaRow, deltaCol);
            }
            if (board[i][board[0].length - 1] == 'O' && !visited[i][board[0].length - 1]) {
                dfs(i, board[0].length - 1, board, visited, deltaRow, deltaCol);
            }
        }

        // first row and last row
        for (int i = 0; i < visited[0].length; i++) {
            if (board[0][i] == 'O' && !visited[0][i]) {
                dfs(0, i, board, visited, deltaRow, deltaCol);
            }
            if (board[board.length - 1][i] == 'O' && !visited[board.length - 1][i]) {
                dfs(board.length - 1, i, board, visited, deltaRow, deltaCol);
            }
        }

        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                if (!visited[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    void dfs(int i, int j, char[][] board, boolean[][] visited, int[] deltaRow, int[] deltaCol) {
        visited[i][j] = true;
        for (int k = 0; k < 4; k++) {
            int nrow = i + deltaRow[k];
            int nCol = j + deltaCol[k];
            if (nrow >= 0 && nrow < board.length && nCol >= 0 && nCol < board[0].length && board[nrow][nCol] == 'O' && !visited[nrow][nCol]) {
                dfs(nrow, nCol, board, visited, deltaRow, deltaCol);
            }
        }
    }
}
