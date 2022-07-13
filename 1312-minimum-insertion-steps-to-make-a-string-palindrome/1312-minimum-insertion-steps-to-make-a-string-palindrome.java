class Solution {

    public int minInsertions(String s) {
        char[] text1C = s.toCharArray();
        char[] text2C = new StringBuilder(s).reverse().toString().toCharArray();
        int[][] arr = new int[text1C.length + 1][text2C.length + 1];
        //         for (int i = 0; i < text1C.length; i++) {
        //             arr[i][0] = 0;
        //         }
        //         for (int i = 0; i < text2C.length; i++) {
        //             arr[0][i] = 0;
        //         }

        //         for (int i = 1; i < arr.length; i++) {
        //             for (int j = 1; j < arr[0].length; j++) {
        //                 if (text1C[i - 1] == text2C[j - 1]) {
        //                     arr[i][j] = 1 + arr[i - 1][j - 1];
        //                 } else {
        //                     arr[i][j] = Math.max(arr[i - 1][j], arr[i][j - 1]);
        //                 }
        //             }
        //         }
        return text1C.length - longestCommonSubsequenceRecurrsion(text1C, text2C, text1C.length, text2C.length, arr);
    }

    private int longestCommonSubsequenceRecurrsion(char[] text1, char[] text2, int length1, int length2, int[][] t) {
        if (length1 == 0 || length2 == 0) {
            return 0;
        }
        if (t[length1][length2] != 0) {
            return t[length1][length2];
        } else {
            if (text1[length1 - 1] == text2[length2 - 1]) {
                return t[length1][length2] = 1 + longestCommonSubsequenceRecurrsion(text1, text2, length1 - 1, length2 - 1, t);
            } else {
                return (
                    t[length1][length2] = Math.max(longestCommonSubsequenceRecurrsion(text1, text2, length1 - 1, length2, t), longestCommonSubsequenceRecurrsion(text1, text2, length1, length2 - 1, t))
                );
            }
        }
    }
}
