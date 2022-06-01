class Solution {

    public int maxProduct(int[] nums) {
        int maxSoFar = nums[0];
        int negMax = nums[0];
        int backMax = nums[nums.length - 1];
        int currSum = Math.max(backMax, negMax);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == 0) {
                negMax = nums[i];
            } else {
                negMax *= nums[i];
            }
            if (nums[(nums.length - 1) - i + 1] == 0) {
                backMax = nums[nums.length - 1 - i];
            } else {
                backMax *= nums[nums.length - 1 - i];
            }
            // currSum = Math.max(nums[i], currSum * nums[i]);
            int currSum_v1 = Math.max(backMax, negMax);
            currSum = Math.max(currSum_v1, currSum);
            maxSoFar = Math.max(maxSoFar, currSum);
        }
        return maxSoFar;
    }
}
