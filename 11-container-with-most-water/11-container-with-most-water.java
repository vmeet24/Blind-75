class Solution {
    public int maxArea(int[] height) {
        int max_area = -1;
        int i = 0;
        int j = height.length - 1;
        while (i < j) {
            max_area = Math.max(max_area, Math.abs(j - i) * Math.min(height[i], height[j]));
            if (height[i] < height[j]) {
                i += 1;
            } else {
                j -= 1;
            }
        }
        return max_area;
    }
}