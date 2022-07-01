class Solution {
    public int longestPalindromeSubseq(String s) {
        char[] text1C = s.toCharArray();
        String text2 = new StringBuilder(s).reverse().toString();
        char[] text2C = text2.toCharArray();
        int[][] arr = new int[text1C.length + 1][text2C.length + 1];
        for (int i = 0; i < text1C.length; i++) {
            arr[i][0] = 0;
        }
        for (int i = 0; i < text2C.length; i++) {
            arr[0][i] = 0;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[0].length; j++) {
                if (text1C[i - 1] == text2C[j - 1]) {
                    arr[i][j] = 1 + arr[i - 1][j - 1];
                } else {
                    arr[i][j] = Math.max(arr[i - 1][j], arr[i][j - 1]);
                }
            }
        }
        return arr[text1C.length][text2C.length];
    }
}