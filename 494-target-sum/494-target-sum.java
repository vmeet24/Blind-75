class Solution {

    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum < Math.abs(target) || (sum - target) % 2 != 0) return 0;
        int s2 = (sum - target) / 2;
        int count = subset(nums, s2);
        return count;
    }

    private int subset(int[] arr, int target) {
        int[][] dp = new int[arr.length + 1][target + 1];

        for (int i = 0; i < target + 1; i++) dp[0][i] = 0;

        for (int i = 0; i < arr.length + 1; i++) dp[i][0] = 1;

        for (int i = 1; i < arr.length + 1; i++) {
            for (int j = 0; j < target + 1; j++) {
                // nt include
                if (arr[i - 1] > j) dp[i][j] = dp[i - 1][j]; else dp[i][j] = dp[i - 1][j] + dp[i - 1][j - arr[i - 1]];
            }
        }

        return dp[arr.length][target];
    }
}
