class Solution {

    public int climbStairs(int n) {
        int[] arr = new int[n];
        return climbStairsUtil(n, arr);
    }

    private int climbStairsUtil(int n, int[] arr) {
        if (n == 0 || n == 1) {
            return 1;
        }

        if (arr[n - 1] != 0) {
            return arr[n - 1];
        }

        return arr[n - 1] = climbStairsUtil(n - 1, arr) + climbStairsUtil(n - 2, arr);
    }
}
