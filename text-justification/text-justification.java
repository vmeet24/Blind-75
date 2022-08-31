class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        List<String> curr = new ArrayList<>();
        int i = 0;
        int width = 0;
        while (i < words.length) {
            String currWord = words[i];
            if (width + currWord.length() <= maxWidth) {
                curr.add(currWord);
                width += currWord.length() + 1;
                i++;
            } else {
                int totalSpaces = maxWidth - width + curr.size();
                int space = 0;
                int j = 0;
                while (space < totalSpaces) {
                    if (j >= curr.size() - 1) {
                        j = 0;
                    }
                    curr.set(j, curr.get(j) + " ");
                    j++;
                    space++;
                }
                StringBuilder sb = new StringBuilder();
                for (String string : curr) {
                    sb.append(string);
                }
                res.add(sb.toString());
                width = 0;
                curr.clear();
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < curr.size() - 1; j++) {
            sb.append(curr.get(j)).append(" ");
        }
        sb.append(curr.get(curr.size() - 1)).append(" ".repeat(maxWidth - sb.length()));
        res.add(sb.toString());
        return res;
    }
}