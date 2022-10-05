class Solution {

    class Pair {
        int row;
        int col;
        int time;

        Pair(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }

    public int orangesRotting(int[][] grid) {
        Queue<Pair> queue = new ArrayDeque<>();
        int freshOranges = getFreshOrangesAndAddRottenOranges(grid, queue);
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int[] delRow = { 0, -1, 0, 1 };
        int[] delCol = { -1, 0, 1, 0 };
        int maxTime = 0;
        while (!queue.isEmpty()) {
            Pair rottenOrange = queue.poll();
            visited[rottenOrange.row][rottenOrange.col] = true;
            maxTime = Math.max(maxTime, rottenOrange.time);

            for (int i = 0; i < delRow.length; i++) {
                for (int j = 0; j < delCol.length; j++) {
                    int row = rottenOrange.row + delRow[i];
                    int col = rottenOrange.col + delCol[i];
                    if (row >= 0 && row < n && col >= 0 && col < m && grid[row][col] == 1 && !visited[row][col]) {
                        freshOranges--;
                        grid[row][col] = 2;
                        queue.add(new Pair(row, col, rottenOrange.time + 1));
                    }
                }
            }
        }
        return freshOranges == 0 ? maxTime : -1;
    }

    int getFreshOrangesAndAddRottenOranges(int[][] grid, Queue<Pair> queue) {
        int freshOranges = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new Pair(i, j, 0));
                } else if (grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }
        return freshOranges;
    }
}
