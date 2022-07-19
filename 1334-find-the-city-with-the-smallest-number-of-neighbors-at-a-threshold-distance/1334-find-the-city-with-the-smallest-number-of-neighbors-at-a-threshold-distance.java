class Solution {

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] arr = new int[n][n];

        for (int[] is : arr) {
            Arrays.fill(is, Integer.MAX_VALUE / 2);
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i][i] = 0;
        }

        for (int i = 0; i < edges.length; i++) {
            int[] curr = edges[i];
            arr[curr[0]][curr[1]] = arr[curr[1]][curr[0]] = curr[2];
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length; j++) {
                    arr[i][j] = Math.min(arr[i][k] + arr[k][j], arr[i][j]);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            int curr = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] > 0 && arr[i][j] <= distanceThreshold) {
                    curr++;
                }
            }
            if (curr <= min) {
                min = curr;
                idx = i;
            }
        }
        return idx;
    }
}
