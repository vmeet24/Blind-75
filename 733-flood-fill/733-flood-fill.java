class Solution {
    class Pair {
        int row;
        int col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Queue<Pair> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[image.length][image[0].length];
        queue.add(new Pair(sr, sc));
        int initialColor = image[sr][sc];
        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            image[p.row][p.col] = color;
            visited[p.row][p.col] = true;
            if (p.row + 1 < image.length && image[p.row + 1][p.col] == initialColor && !visited[p.row + 1][p.col]) {
                queue.add(new Pair(p.row + 1, p.col));
            }
            if (p.row - 1 >= 0 && image[p.row - 1][p.col] == initialColor && !visited[p.row - 1][p.col]) {
                queue.add(new Pair(p.row - 1, p.col));
            }
            if (p.col + 1 < image[0].length && image[p.row][p.col + 1] == initialColor && !visited[p.row][p.col + 1]) {
                queue.add(new Pair(p.row, p.col + 1));
            }
            if (p.col - 1 >= 0 && image[p.row][p.col - 1] == initialColor && !visited[p.row][p.col - 1]) {
                queue.add(new Pair(p.row, p.col - 1));
            }
        }
        return image;
    }
}