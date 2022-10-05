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
        List<Pair> rottenPairs = getRottenOranges(grid);
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int[] delRow = { 0, -1, 0, 1 };
        int[] delCol = { -1, 0, 1, 0 };
        for (Pair pair : rottenPairs) {
            queue.add(new Pair(pair.row, pair.col, 0));
        }
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
                        grid[row][col] = 2;
                        queue.add(new Pair(row, col, rottenOrange.time + 1));
                    }
                }
            }
        }
        return checkRotten(grid) ? maxTime : -1;
    }

    List<Pair> getRottenOranges(int[][] grid) {
        List<Pair> pair = new ArrayList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    pair.add(new Pair(i, j, 0));
                }
            }
        }
        return pair;
    }

    boolean checkRotten(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
