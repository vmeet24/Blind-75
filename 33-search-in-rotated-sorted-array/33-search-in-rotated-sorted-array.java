class Solution {

    //nlogn
    //      public int search(int[] nums, int target) {
    //         int idx = -1;
    //         int low = 0;
    //         int high = nums.length - 1;
    //         idx = find(low, high, nums, target);
    //         return idx;
    //     }

    //     private int find(int low, int high, int[] nums, int target) {
    //         int mid = (int) Math.floor((high + low) / 2);
    //         if (nums[mid] == target) {
    //             return mid;
    //         }
    //         if (low < high) {
    //             int left = find(low, mid - 1, nums, target);
    //             int right = find(mid + 1, high, nums, target);
    //             if (left != -1) {
    //                 return left;
    //             } else {
    //                 return right;
    //             }
    //         }
    //         return -1;
    //     }

    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (int) (Math.floor(high + low) / 2);
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[low] <= nums[mid]) {
                if (target < nums[mid] && target >= nums[low]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            if (nums[mid] <= nums[high]) {
                if (target > nums[mid] && target<= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
