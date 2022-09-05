class Solution {

    public String minWindow(String s, String t) {
        StringBuilder window = new StringBuilder();
        List<String> lst = new ArrayList<>();
        Map<Character, Integer> tHS = new HashMap<>();
        int count = 0;
        for (Character character : t.toCharArray()) {
            if (tHS.containsKey(character)) {
                tHS.put(character, tHS.get(character) + 1);
            } else {
                tHS.put(character, 1);
                count++;
            }
        }
        int i = 0, j = 0;
        while (j < s.length()) {
            char c = s.charAt(j);
            window.append(c);
            if (tHS.containsKey(c)) {
                tHS.put(c, tHS.get(c) - 1);
                if (tHS.get(c) == 0) {
                    count--;
                }
                if (count == 0) {
                    while (count == 0) {
                        if (!tHS.containsKey(window.charAt(0))) {
                            window.deleteCharAt(0);
                            i++;
                        } else if (tHS.get(window.charAt(0)) < 0) {
                            tHS.put(window.charAt(0), tHS.get(window.charAt(0)) + 1);
                            window.deleteCharAt(0);
                            i++;
                        } else if (tHS.get(window.charAt(0)) == 0) {
                            lst.add(window.toString());
                            tHS.put(window.charAt(0), 1);
                            window.deleteCharAt(0);
                            i++;
                            count++;
                        }
                    }
                }
            }
            j++;
        }

        var res = lst.stream().sorted(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        }).collect(Collectors.toList());
        return res.size() > 0 ? res.get(0) : "";
    }
}
