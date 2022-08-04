class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 1){
            return s.length();
        }
        int i = 0, j = 0;
        int res = 0;
        Map<Character, Integer> mp = new HashMap<>();
        while (j < s.length()) {
            if (mp.containsKey(s.charAt(j))) {
                if (mp.get(s.charAt(j)) >= i) {
                    i = mp.get(s.charAt(j)) + 1;
                }
            }
            res = Math.max(res, j - i+1);
            mp.put(s.charAt(j), mp.get(s.charAt(j)) == null ? j : j);
            j++;
        }
        return res;
    }
}