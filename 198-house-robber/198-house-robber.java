class Solution {

    public int rob(int[] nums) {
        int[] arr = new int[nums.length + 1];
        Arrays.fill(arr, -2);
        return robUtil(nums.length, nums, arr);
    }

    private int robUtil(int n, int[] nums, int[] arr) {
        if (n <= 0) {
            return 0;
        }
        if (arr[n] != -2) {
            return arr[n];
        }
        return arr[n] = Math.max(nums[n - 1] + robUtil(n - 2, nums, arr), robUtil(n - 1, nums, arr));
    }
}
