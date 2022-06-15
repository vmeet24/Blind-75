class Solution {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int half = sum / 2;
        boolean[][] t = new boolean[nums.length + 1][half + 1];

        for (int i = 0; i < half + 1; i++) {
            t[0][i] = false;
        }

        for (int i = 0; i < nums.length + 1; i++) {
            t[i][0] = true;
        }
        for (int i = 1; i < t.length; i++) {
            for (int j = 1; j < t[0].length; j++) {
                if (nums[i - 1] <= j) {
                    t[i][j] = t[i-1][j - nums[i - 1]] || t[i - 1][j];
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }
        return t[nums.length][half];
    }
}
