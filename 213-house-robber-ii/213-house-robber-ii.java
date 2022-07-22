class Solution {

    public int rob(int[] nums) {
        int[] arr = new int[nums.length + 1];
        Arrays.fill(arr, -2);
        int a = robUtil(nums.length - 1, nums, arr);
        reverse(nums);
        Arrays.fill(arr, -2);
        int b = robUtil(nums.length - 1, nums, arr);
        int c = Math.max(a, b);
        return Math.max(nums[0], c);
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

    public static void reverse(int[] data) {
        for (int left = 0, right = data.length - 1; left < right; left++, right--) {
            // swap the values at the left and right indices
            int temp = data[left];
            data[left] = data[right];
            data[right] = temp;
        }
    }
}
