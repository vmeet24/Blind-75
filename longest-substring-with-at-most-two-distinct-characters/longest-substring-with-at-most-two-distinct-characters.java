class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int k = 2;
        Map<Character, Integer> mp = new HashMap<>();
        int i = 0, j = 0;
        int max = 0;
        int size = 0;
        while (j < s.length()) {
            char c = s.charAt(j);
            if (!mp.containsKey(c)) {
                mp.put(c, 1);
                size++;
            } else {
                mp.put(c, mp.get(c) + 1);
            }
            if (mp.size() > k) {
                while (size > k) {
                    mp.put(s.charAt(i), mp.get(s.charAt(i)) - 1);
                    if (mp.get(s.charAt(i)) == 0) {
                        mp.remove(s.charAt(i));
                        size--;
                    }
                    i++;
                }
            }
            max = Math.max(max, j - i + 1);
            j++;
        }
        System.out.println(max);
        return max;
    }
}