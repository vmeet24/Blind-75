class Solution {
    public int expressiveWords(String s, String[] words) {
         List<int[]> ls = getCompressedWord(s);
        int res = 0;
        for (int i = 0; i < words.length; i++) {
            boolean flag = true;
            if (words[i].length() > s.length()) {
                continue;
            }
            if (words[i].equals(s)) {
                res++;
            } else {
                HashMap<Character, Integer> mp1 = new HashMap<>();
                List<int[]> ls1 = getCompressedWord(words[i]);
                if (ls.size() == ls1.size()) {
                    for (int j = 0; j < ls.size(); j++) {
                        if (ls.get(j)[0] == ls1.get(j)[0]) {
                            if (ls.get(j)[1] == ls1.get(j)[1]) {
                                continue;
                            }
                            if (ls1.get(j)[1] < ls.get(j)[1] && ls.get(j)[1] >= 3) {
                                continue;
                            } else {
                                flag = false;
                            }
                        } else {
                            flag = false;
                        }
                    }

                } else {
                    flag = false;
                }
            }
            if (flag) {
                res++;
            }
        }
        return res;
    }

    private List<int[]> getCompressedWord(String s) {
        List<int[]> ls = new ArrayList<>();
        ls.add(0, new int[] { s.charAt(0), 1 });
        int i = 1;
        int k = 0;
        while (i < s.length()) {
            if (s.charAt(i) == s.charAt(i-1)) {
                ls.set(k, new int[] { ls.get(k)[0], ls.get(k)[1] + 1 });
            } else {
                k++;
                ls.add(k, new int[] { s.charAt(i), 1 });
            }
            i++;
        }
        return ls;
    }
}
