public class MinimumSubsetDifference {
    public int minimumDifference(int[] nums) {
        int sum = 0;

        for (int num : nums)
            sum += num;
        int min = sum + 1;
        boolean[] arr = subset(nums, (int) Math.ceil(sum / 2));
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]) {
                min = Math.min(min, sum - 2 * i);
            }
        }
        return min;
    }

    private boolean[] subset(int[] arr, int target) {
        boolean[][] dp = new boolean[arr.length + 1][target + 1];

        for (int i = 0; i < target + 1; i++)
            dp[0][i] = false;

        for (int i = 0; i < arr.length + 1; i++)
            dp[i][0] = true;

        for (int i = 1; i < arr.length + 1; i++) {
            for (int j = 1; j < target + 1; j++) {
                // nt include
                if (arr[i - 1] > j)
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
            }
        }

        return dp[arr.length];
    }
}
