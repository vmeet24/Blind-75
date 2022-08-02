class Solution {
    public String licenseKeyFormatting(String s, int k) {
         s = s.replace("-", "");
        int count = 0;
        StringBuilder res = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (res.length() > 0 && count % k == 0) {
                res.append("-");
                count = 0;
            }
            count++;
            res.append(Character.toUpperCase(s.charAt(i)));
        }
        return res.reverse().toString();
    }
}