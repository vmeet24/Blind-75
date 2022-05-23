class Solution {
    public int findMin(int[] nums) {
        int min = Integer.MAX_VALUE;
        int low = 0;
        int high = nums.length - 1;
        int mid = -1;
        while (low <= high) {
            mid = (int) (Math.floor(high + low) / 2);
            min = Math.min(nums[mid], min);
            if (nums[low] <= nums[mid]) {
                min = Math.min(nums[low], min);
                low = mid + 1;
            }
            else {
                min = Math.min(nums[mid], min);
                high = mid - 1;
            }
        }
        return min;
    }
}