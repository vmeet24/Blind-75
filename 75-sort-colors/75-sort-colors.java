class Solution {

    public void sortColors(int[] nums) {
        int low = 0, mid = 0;
        int high = nums.length - 1;
        while (high >= mid) {
            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 2) {
                swap(nums, high, mid);
                high--;
            } else {
                mid++;
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
