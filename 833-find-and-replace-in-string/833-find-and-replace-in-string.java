class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        StringBuilder str = new StringBuilder(s);
        int i = 0;
        Map<Integer, String[]> treeMap = new TreeMap<>();
        for (int j = 0; j < targets.length; j++) {
            treeMap.put(indices[j], new String[] { sources[j], targets[j] });
        }

        Set<Integer> set = treeMap.keySet();
        Iterator<Integer> it = set.iterator();

        while (it.hasNext()) {
            int offset = it.next();
            String source = treeMap.get(offset)[0];
            String target = treeMap.get(offset)[1];
            offset += i; //to reach at the correct index so that we can compare with the offset value.
            if (str.substring(offset, offset + source.length()).equals(source)) {
                str.replace(offset, offset + source.length(), target);
                i += target.length() - source.length();
            }
        }
        return str.toString();
    }
}