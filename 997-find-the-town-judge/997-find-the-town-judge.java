class Solution {

    public int findJudge(int n, int[][] trust) {
        int[][] arr = new int[n][n];
        for (int i = 0; i < trust.length; i++) {
            arr[trust[i][0] - 1][trust[i][1] - 1] = 1;
        }

        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j][i] != 0) {
                    count++;
                }
            }
            if (count == n - 1) {
                boolean flag = false;
                for (int k = 0; k < n; k++) {
                    if (arr[i][k] != 0) {
                        flag = true;
                    }
                }
                if (!flag) {
                    return i + 1;
                }
            }
        }
        return -1;
    }
}
