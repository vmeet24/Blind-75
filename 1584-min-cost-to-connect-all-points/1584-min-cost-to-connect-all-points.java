class UnionFind {
        int edgeCounted = 0;
        int[] arr;

        public UnionFind(int length) {
            arr = new int[length];
            Arrays.fill(arr, -1);
        }

        private int find(int x) {
            int parent = x;
            int value = arr[x];
            while (value >= 0) {
                parent = value;
                value = arr[parent];
            }
            return parent;
        }

        public boolean union(int x, int y) {
            int parent1 = find(x);
            int parent2 = find(y);

            if (parent1 == parent2) {
                return false;
            }

            if (arr[parent1] <= arr[parent2]) {
                arr[parent1] = arr[parent1] + arr[parent2];
                arr[parent2] = parent1;
                arr[y] = parent1;
            } else if (arr[parent1] > arr[parent2]) {
                arr[parent2] = arr[parent1] + arr[parent2];
                arr[parent1] = parent2;
                arr[x] = parent2;
            }
            return true;
        }
    }

class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        ArrayList<int[]> allEdges = new ArrayList<>();

        // Storing all edges of our complete graph.
        for (int currNext = 0; currNext < n; ++currNext) {
            for (int nextNext = currNext + 1; nextNext < n; ++nextNext) {
                int weight = Math.abs(points[currNext][0] - points[nextNext][0]) +
                        Math.abs(points[currNext][1] - points[nextNext][1]);

                int[] currEdge = { weight, currNext, nextNext };
                allEdges.add(currEdge);
            }
        }

        // Sort all edges in increasing order.
        Collections.sort(allEdges, (a, b) -> Integer.compare(a[0], b[0]));

        UnionFind uf = new UnionFind(n);
        int mstCost = 0;
        int edgesUsed = 0;

        for (int i = 0; i < allEdges.size() && edgesUsed < n - 1; ++i) {
            int node1 = allEdges.get(i)[1];
            int node2 = allEdges.get(i)[2];
            int weight = allEdges.get(i)[0];

            if (uf.union(node1, node2)) {
                mstCost += weight;
                edgesUsed++;
            }
        }

        return mstCost;
    }
}