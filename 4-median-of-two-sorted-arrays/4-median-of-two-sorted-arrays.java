class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0, j = 0, k = 0;
        int[] arr = new int[nums1.length + nums2.length];
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] > nums2[j]) {
                arr[k] = nums2[j];
                j++;
            } else {
                arr[k] = nums1[i];
                i++;
            }
            k++;
        }
        while (i != nums1.length) {
            arr[k] = nums1[i];
            i++;
            k++;
        }
        while (j != nums2.length) {
            arr[k] = nums2[j];
            j++;
            k++;
        }
        
        return arr.length % 2 == 0 ? (arr[arr.length / 2 - 1] + arr[arr.length / 2])/2.0:arr[arr.length / 2];
    }
}