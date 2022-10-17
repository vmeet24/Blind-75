class Solution {

    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        for (int j = 0; j < graph.length; j++) {
            if (color[j] == 0) {
                if (!checkGraphDFS(j, graph, color, 1)) {
                    return false;
                }
            }
        }
        return true;
    }

    //     private boolean checkGraph(int node, int[][] graph, int[] color) {
    //         Queue<Integer> queue = new ArrayDeque<>();
    //         queue.add(node);
    //         color[node] = 1;
    //         while (!queue.isEmpty()) {
    //             int currNode = queue.poll();

    //             for (int i = 0; i < graph[currNode].length; i++) {
    //                 if (color[graph[currNode][i]] != 0) {
    //                     if (color[graph[currNode][i]] == color[currNode]) {
    //                         return false;
    //                     }
    //                 } else {
    //                     color[graph[currNode][i]] = 1 == color[currNode] ? 2 : 1;
    //                     queue.add(graph[currNode][i]);
    //                 }
    //             }
    //         }
    //         return true;
    //     }

    private boolean checkGraphDFS(int node, int[][] graph, int[] colors, int color) {
        colors[node] = color;

        for (int i = 0; i < graph[node].length; i++) {
            int neighborNode = graph[node][i];
            if (colors[neighborNode] == 0) {
                if(!checkGraphDFS(neighborNode, graph, colors, colors[node] == 1 ? 2 : 1)){
                    return false;
                }
            } else if (colors[neighborNode] == colors[node]) {
                return false;
            }
        }

        return true;
    }
}
