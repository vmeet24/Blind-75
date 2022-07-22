class Solution {

    public int climbStairs(int n) {
        int[] arr = new int[n + 1];
        Arrays.fill(arr, -2);
        return climbStairsUtil(n, arr);
    }

    private int climbStairsUtil(int n, int[] arr) {
        if (n == 0 || n == 1) {
            return 1;
        }

        if (arr[n] != -2) {
            return arr[n];
        }

        return arr[n] = climbStairsUtil(n - 1, arr) + climbStairsUtil(n - 2, arr);
    }
}
