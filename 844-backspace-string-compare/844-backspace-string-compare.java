class Solution {

    public boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1;
        int j = t.length() - 1;
        int countS = 0;
        int countT = 0;

        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (s.charAt(i) == '#') {
                    i--;
                    countS++;
                } else if (countS > 0) {
                    i--;
                    countS--;
                } else {
                    break;
                }
            }

            while (j >= 0) {
                if (t.charAt(j) == '#') {
                    j--;
                    countT++;
                } else if (countT > 0) {
                    j--;
                    countT--;
                } else {
                    break;
                }
            }

            if (i >= 0 && j >= 0 && s.charAt(i) != t.charAt(j)) {
                return false;
            }
            if ((i >= 0) != (j >= 0)) return false;
            i--;
            j--;
        }
        return true;
    }
}
