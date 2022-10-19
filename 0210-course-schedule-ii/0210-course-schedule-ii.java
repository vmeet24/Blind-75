class Solution {

    class Node {
        private int node;
        private List<Integer> children;

        Node(int node) {
            this.node = node;
            this.children = new ArrayList();
        }
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, Node> graph = new HashMap();

        int[] indegrees = new int[numCourses];

        for (int[] edge : prerequisites) {
            indegrees[edge[0]]++;
            if (!graph.containsKey(edge[1])) {
                Node parent = new Node(edge[1]);
                graph.put(edge[1], parent);
            }
            if (!graph.containsKey(edge[0])) {
                Node child = new Node(edge[0]);
                graph.put(edge[0], child);
            }
            Node node = graph.get(edge[1]);
            node.children.add(edge[0]);
        }

        int[] res = new int[numCourses];
        Queue<Integer> queue = new ArrayDeque();

        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                queue.add(i);
            }
        }

        int i = 0;
        int count = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            res[i++] = node;
            count++;
            if (graph.containsKey(node)) {
                Node currNode = graph.get(node);
                for (Integer neighbor : currNode.children) {
                    indegrees[neighbor]--;
                    if (indegrees[neighbor] == 0) {
                        queue.add(neighbor);
                    }
                }
            }
        }
        return count == numCourses? res: new int[]{};
    }
}
