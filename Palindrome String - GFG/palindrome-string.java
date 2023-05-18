//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.isPalindrome(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int isPalindrome(String S) {
        char[] arr = S.toCharArray();
        String revS = reverseArr(arr, 0, S.length()-1);
        if(S.equals(revS)){
            return 1;
        }
        return 0;
    }
    
    String reverseArr(char[] arr, int left, int right){
        if(left >= right){
            return new String(arr);
        }
        else{
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            return reverseArr(arr, left+1, right - 1);
        }
    }
};