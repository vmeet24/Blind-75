class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        int countZero = 0;
        int i = 0, j = 0;
        int maxValue = 0;
        int maxIdx = 0;
        while (i < nums.length) {
            for (int k = 0; k < nums[i]; k++) {
                j++;
                if (j == nums.length - 1) {
                    return true;
                }
                if (maxValue <= nums[j]) {
                    maxIdx = j;
                    maxValue = nums[j];
                }
                if (nums[j] == 0) {
                    countZero++;
                }

            }
            if (j == nums.length - 1) {
                return true;
            }
            i = countZero == nums[maxIdx] ? j : maxIdx;
            j = i;
            if (maxIdx == 0) {
                return false;
            }
            maxIdx = 0;
            maxValue = 0;
            countZero = 0;
        }

        return true;
    }
}