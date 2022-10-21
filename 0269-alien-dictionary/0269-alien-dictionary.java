class Solution {

    public String alienOrder(String[] words) {
        Map<Character, List<Character>> graph = new HashMap<>();
        Map<Character, Integer> indegrees = new HashMap<>();
        for (String string : words) {
            for (Character c : string.toCharArray()) {
                indegrees.put(c, 0);
                graph.put(c, new ArrayList<>());
            }
        }

        StringBuilder res = new StringBuilder();

        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            if (word1.length() > word2.length() && word1.startsWith(word2)) {
                return "";
            }

            int minLength = Math.min(word1.length(), word2.length());
            for (int j = 0; j < minLength; j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    graph.get(word1.charAt(j)).add(word2.charAt(j));
                    indegrees.put(word2.charAt(j), indegrees.get(word2.charAt(j)) + 1);
                    break;
                }
            }
        }

        topoSort(graph.size(), graph, res, indegrees);
        return res.length() >= graph.size() ? res.toString() : "";
    }

    void topoSort(int nodes, Map<Character, List<Character>> graph, StringBuilder res, Map<Character, Integer> indegrees) {
        Queue<Character> queue = new ArrayDeque<>();

        for (Map.Entry<Character, Integer> mp : indegrees.entrySet()) {
            if (mp.getValue() == 0) {
                queue.add(mp.getKey());
            }
        }

        while (!queue.isEmpty()) {
            Character c = queue.poll();
            res.append(c);
            for (Character node : graph.get(c)) {
                indegrees.put(node, indegrees.get(node) - 1);
                if (indegrees.get(node) == 0) {
                    queue.add(node);
                }
            }
        }
    }
}
