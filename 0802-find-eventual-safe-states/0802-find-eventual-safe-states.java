class Solution {

    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            if (checkSafeState(i, graph, new boolean[graph.length], new boolean[graph.length])) {
                res.add(i);
            }
        }
        return res;
    }

    private boolean checkSafeState(int i, int[][] graph, boolean[] visited, boolean[] pathVisited) {
        pathVisited[i] = true;
        visited[i] = true;

        for (int neighbor : graph[i]) {
            if (!visited[neighbor]) {
                if (!checkSafeState(neighbor, graph, visited, pathVisited)) {
                    return false;
                }
            } else if (pathVisited[neighbor]) {
                return false;
            }
        }
        pathVisited[i] = false;
        return true;
    }
}
