class Solution {

    public List<Integer> eventualSafeNodes(int[][] graph) {
        boolean[] visited = new boolean[graph.length];
        boolean[] isSafe = new boolean[graph.length];
        List<Integer> res = new ArrayList<>();
        boolean[] pathVisited = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                checkSafeState(i, graph, visited, pathVisited, isSafe);
            }
        }
        
        for(int i = 0; i<isSafe.length; i++){
            if(isSafe[i]){
                res.add(i);
            }
        }
        return res;
    }

    private boolean checkSafeState(int i, int[][] graph, boolean[] visited, boolean[] pathVisited, boolean[] isSafe) {
        pathVisited[i] = true;
        visited[i] = true;
        for (int neighbor : graph[i]) {
            if (!visited[neighbor]) {
                if (!checkSafeState(neighbor, graph, visited, pathVisited, isSafe)) {
                    return false;
                }
            } else if (pathVisited[neighbor]) {
                return false;
            }
        }
        isSafe[i] = true;
        pathVisited[i] = false;
        return true;
    }
}
