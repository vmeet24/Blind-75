class Solution {
    public int numUniqueEmails(String[] emails) {
        StringBuilder s = new StringBuilder();
        Set<String> set = new HashSet<>();
        for (String string : emails) {
            for (int i = 0; i < string.length(); i++) {
                if (string.charAt(i) == '+' || string.charAt(i) == '@') {
                    s.append(string.substring(string.indexOf("@"), string.length()));
                    break;
                } else if (string.charAt(i) != '.') {
                    s.append(string.charAt(i));
                }
            }
            set.add(s.toString());
            s = new StringBuilder();
        }
        return set.size();
    }
}