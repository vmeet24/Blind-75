class Solution {
    public int trap(int[] height) {
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];
        int[] minH = new int[height.length];

        int maxL = Integer.MIN_VALUE;
        maxLeft[0] = height[0];
        for (int i = 1; i < minH.length; i++) {
            maxL = Math.max(maxL, height[i - 1]);
            maxLeft[i] = maxL;
        }

        int maxR = Integer.MIN_VALUE;
        maxRight[0] = height[height.length - 1];
        for (int i = minH.length - 2; i >= 0; i--) {
            maxR = Math.max(maxR, height[i + 1]);
            maxRight[i] = maxR;
        }

        int res = 0;
        for (int i = 0; i < minH.length; i++) {
            int sum = (Math.min(maxLeft[i], maxRight[i]) - height[i]);
            res += sum >= 0 ? sum : 0;
        }
        return res;
    }
}