class Solution {

    class Pair {
        int row;
        int col;

        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public int numDistinctIslands(int[][] grid) {
        int[] deltaRow = { -1, 0, +1, 0 };
        int[] deltaCol = { 0, -1, 0, +1 };
        HashSet<List<String>> res = new HashSet<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    List<String> lst = new ArrayList<>();
                    dfsUtil(i, j, grid, visited, deltaRow, deltaCol, lst, i, j);
                    if (res.contains(lst)) {
                        System.out.println(lst);
                    } else {
                        res.add(lst);
                    }
                }
            }
        }
        return res.size();
    }

    private String toString(int r, int c) {
        return Integer.toString(r) + " " + Integer.toString(c);
    }

    private void dfsUtil(int i, int j, int[][] grid, boolean[][] visited, int[] deltaRow, int[] deltaCol, List<String> lst, int baseRow, int baseCol) {
        visited[i][j] = true;
        lst.add(toString(i - baseRow, j - baseCol));
        for (int k = 0; k < deltaCol.length; k++) {
            int nRow = i + deltaRow[k];
            int nCol = j + deltaCol[k];
            if (nRow >= 0 && nRow < grid.length && nCol >= 0 && nCol < grid[0].length && !visited[nRow][nCol] && grid[nRow][nCol] == 1) {
                dfsUtil(nRow, nCol, grid, visited, deltaRow, deltaCol, lst, baseRow, baseCol);
            }
        }
    }
}
