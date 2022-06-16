public class CountNumberOfSubsetDifference {

    public int countNumberOfSubsetDifference(int[] nums, int difference) {
        int sum = 0;
        for (int num : nums)
            sum += num;
        int s2 = (sum - difference) / 2;
        int count = subset(nums, s2);
        return count;
    }

    private int subset(int[] arr, int target) {
        int[][] dp = new int[arr.length + 1][target + 1];

        for (int i = 0; i < target + 1; i++)
            dp[0][i] = 0;

        for (int i = 0; i < arr.length + 1; i++)
            dp[i][0] = 1;

        for (int i = 1; i < arr.length + 1; i++) {
            for (int j = 1; j < target + 1; j++) {
                // nt include
                if (arr[i - 1] > j)
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - arr[i - 1]];
            }
        }

        return dp[arr.length][target];
    }

    public static void main(String[] args) {
        CountNumberOfSubsetDifference c = new CountNumberOfSubsetDifference();
        System.out.println(c.countNumberOfSubsetDifference(new int[] { 1, 1, 2, 4 }, 1));
    }
}
