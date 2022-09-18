class Solution {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        int res = findPathHelper(m - 1, n - 1, dp);
        return res;
    }

    int findPathHelper(int i, int j, int[][] dp) {
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        if (i == 0 || j == 0) {
            return 1;
        } else {
            return dp[i][j] = findPathHelper(i - 1, j, dp) + findPathHelper(i, j - 1, dp);
        }
    }
}
