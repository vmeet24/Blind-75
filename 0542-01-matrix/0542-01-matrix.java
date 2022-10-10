class Solution {

    class Pair {
        int row;
        int col;
        int distance;

        public Pair(int row, int col, int distance) {
            this.row = row;
            this.col = col;
            this.distance = distance;
        }
    }

    public int[][] updateMatrix(int[][] mat) {
        boolean[][] visited = new boolean[mat.length][mat[0].length];
        int[][] matrix = new int[mat.length][mat[0].length];
        Queue<Pair> queue = new ArrayDeque<>();

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    queue.add(new Pair(i, j, 0));
                    visited[i][j] = true;
                }
            }
        }

        int[] deltaRow = { 0, -1, 0, +1 };
        int[] deltaCol = { -1, 0, +1, 0 };
        int n = mat.length;
        int m = mat[0].length;

        while (!queue.isEmpty()) {
            Pair node = queue.poll();
            int row = node.row;
            int col = node.col;
            visited[row][col] = true;
            matrix[row][col] = node.distance;

            for (int k = 0; k < deltaRow.length; k++) {
                int newRow = row + deltaRow[k];
                int newCol = col + deltaCol[k];
                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && mat[newRow][newCol] == 1 && !visited[newRow][newCol]) {
                    queue.add(new Pair(newRow, newCol, node.distance + 1));
                    visited[newRow][newCol] = true;
                }
            }
        }
        return matrix;
    }
}
