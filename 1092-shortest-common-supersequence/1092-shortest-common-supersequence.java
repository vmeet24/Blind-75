class Solution {

    public String shortestCommonSupersequence(String str1, String str2) {
        char[] text1C = str1.toCharArray();
        char[] text2C = str2.toCharArray();
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

        return printSCS(arr, text1C, text2C);
    }

    private String printSCS(int[][] arr, char[] str1, char[] str2) {
        StringBuilder s = new StringBuilder();
        int i = arr.length - 1;
        int j = arr[0].length - 1;
        while (i != 0 && j != 0) {
            if (str1[i - 1] == str2[j - 1]) {
                s.append(str1[i - 1]);
                i--;
                j--;
            } else {
                if (arr[i - 1][j] > arr[i][j - 1]) {
                    s.append(str1[i - 1]);
                    i--;
                } else {
                    s.append(str2[j - 1]);
                    j--;
                }
            }
        }
        while(i>0){
           s.append(str1[i - 1]);
            i--;
        }
        
        while(j>0){
             s.append(str2[j - 1]);
            j--;
        }
        return s.reverse().toString();
    }
}
