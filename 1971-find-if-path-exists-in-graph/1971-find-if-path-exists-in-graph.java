class Solution {

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> graph = new ArrayList<>();
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            graph.add(i, new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }

        Stack<Integer> stack = new Stack<>();
        stack.add(source);
        while (!stack.isEmpty()) {
            Integer node = stack.pop();
            visited[node] = true;
            List<Integer> neighbors = graph.get(node);

            for (Integer integer : neighbors) {
                if (!visited[integer]) {
                    stack.add(integer);
                }
            }
        }

        return visited[destination];
    }
}
