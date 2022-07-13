// class Solution {
// static int[][] t = new int[text1.length() + 1][text2.length() + 1];
//     public int longestCommonSubsequence(String text1, String text2) {
        
//         for (int[] is : t) {
//             Arrays.fill(is, 0);
//         }
//         return longestCommonSubsequenceRecurrsion(text1, text2, text1.length(), text2.length(), t);
//         //         char[] text1C = text1.toCharArray();
//         //         char[] text2C = text2.toCharArray();
//         //         int[][] arr = new int[text1C.length + 1][text2C.length + 1];
//         //         for (int i = 0; i < text1C.length; i++) {
//         //             arr[i][0] = 0;
//         //         }
//         //         for (int i = 0; i < text2C.length; i++) {
//         //             arr[0][i] = 0;
//         //         }

//         //         for (int i = 1; i < arr.length; i++) {
//         //             for (int j = 1; j < arr[0].length; j++) {
//         //                 if (text1C[i - 1] == text2C[j - 1]) {
//         //                     arr[i][j] = 1 + arr[i - 1][j - 1];
//         //                 } else {
//         //                     arr[i][j] = Math.max(arr[i - 1][j], arr[i][j - 1]);
//         //                 }
//         //             }
//         //         }
//         //         return arr[text1C.length][text2C.length];
//         //     }
//     }

//     private int longestCommonSubsequenceRecurrsion(String text1, String text2, int length1, int length2, int[][] t) {
//         if (length1 == 0 || length2 == 0) {
//             return 0;
//         }
//         if (t[length1][length2] != 0) {
//             return t[length1][length2];
//         } else {
//             if (text1.toCharArray()[length1 - 1] == text2.toCharArray()[length2 - 1]) {
//                 t[length1][length2] = 1 + longestCommonSubsequenceRecurrsion(text1, text2, length1 - 1, length2 - 1, t);
//                 return t[length1][length2];
//             } else {
//                 t[length1][length2] = Math.max(longestCommonSubsequenceRecurrsion(text1, text2, length1 - 1, length2, t), longestCommonSubsequenceRecurrsion(text1, text2, length1, length2 - 1, t));
//                 return t[length1][length2];
//             }
//         }
//     }
// }

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        return helper(text1, text2, 0, 0, new Integer[text1.length()][text2.length()]);
    }
    
    public int helper(String t1, String t2, int p1, int p2, Integer[][] memo) {
        if (p1 >= t1.length() || p2 >= t2.length()) {
            return 0;
        }
        if (memo[p1][p2] != null) {
            return memo[p1][p2];
        }
        if (t1.charAt(p1) == t2.charAt(p2)) {
            return memo[p1][p2] = 1 + helper(t1, t2, p1 + 1, p2 + 1, memo);
        } else {
            return memo[p1][p2] = Math.max(helper(t1, t2, p1 + 1, p2, memo), helper(t1, t2, p1, p2 + 1, memo));
        }
    }
}
