class Solution {

    class Node {
        List<Integer> children;

        Node() {
            children = new ArrayList<>();
        }
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegreesLst = new int[numCourses];
        Map<Integer, Node> graph = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new Node());
        }

        for (int[] preq : prerequisites) {
            graph.get(preq[1]).children.add(preq[0]);
            inDegreesLst[preq[0]]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int j = 0; j < inDegreesLst.length; j++) {
            if (inDegreesLst[j] == 0) {
                queue.add(j);
            }
        }

        int nodes = 0;
        while (!queue.isEmpty()) {
            int currNode = queue.poll();
            nodes++;
            for (Integer child : graph.get(currNode).children) {
                inDegreesLst[child]--;
                if (inDegreesLst[child] == 0) {
                    queue.add(child);
                }
            }
        }
        if (nodes == numCourses) {
            return true;
        }
        return false;
    }
}
