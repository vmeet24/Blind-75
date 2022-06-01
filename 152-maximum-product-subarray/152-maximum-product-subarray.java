class Solution {

    public int maxProduct(int[] nums) {
        int forwardMax = nums[0];
        int backwardMax = nums[nums.length - 1];
        int maxSoFar = Math.max(backwardMax, forwardMax);
        int currMax = maxSoFar;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == 0) {
                forwardMax = nums[i];
            } else {
                forwardMax *= nums[i];
            }
            if (nums[(nums.length - 1) - i + 1] == 0) {
                backwardMax = nums[nums.length - 1 - i];
            } else {
                backwardMax *= nums[nums.length - 1 - i];
            }
            currMax = Math.max(backwardMax, forwardMax);
            maxSoFar = Math.max(currMax, maxSoFar);
        }
        return maxSoFar;
    }
}
