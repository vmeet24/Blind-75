class UnionFind {
    int edgeCounted = 0;
    int[] arr;

    public UnionFind(int length) {
        arr = new int[length];
        // Initializing the array with -1. Negative sign indicates the root node and the
        // value indicates the number of nodes connected to the root node.
        Arrays.fill(arr, -1);
    }

    // Method to find the parent of the selected node.
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

        // If parents are same then cycle is detected, do not include.
        if (parent1 == parent2) {
            return false;
        }

        // Check the size of the root nodes of both the vertex. Select the root node
        // with maximum nodes are connected.
        if (arr[parent1] <= arr[parent2]) {
            // connect the node to the root node with max size.
            arr[parent1] = arr[parent1] + arr[parent2];
            // Update the root of the parent2 node to parent1 with maximum nodes.
            arr[parent2] = parent1;
            // Also update the root node of the selected vertex to the parent1 node. This
            // will eventually make the algorithm efficient. This is called collapsing
            // find/compressed path.
            arr[y] = parent1;
        } else {
            arr[parent2] = arr[parent1] + arr[parent2];
            arr[parent1] = parent2;
            arr[x] = parent2;
        }
        return true;
    }
}

class Solution {

    public int minCostConnectPoints(int[][] points) {
        int arrSize = points.length;
        ArrayList<int[]> lst = new ArrayList<>();

        // Finding all the edges by connecting one vertex to all other vertex .i.e dense
        // graph
        for (int i = 0; i < arrSize; i++) {
            for (int j = i + 1; j < arrSize; j++) {
                int weight = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                int[] node = { weight, i, j };
                lst.add(node);
            }
        }

        // Sorting all the edges in ascending order.
        Collections.sort(
            lst,
            (x, y) -> {
                return Integer.compare(x[0], y[0]);
            }
        );

        int res = 0;
        int edgeCounted = 0;

        // Using union find technique to detect the cycle.
        UnionFind uc = new UnionFind(arrSize);
        for (int i = 0; i < lst.size() && edgeCounted < arrSize - 1; i++) {
            int x = lst.get(i)[1];
            int y = lst.get(i)[2];
            int weight = lst.get(i)[0];
            if (uc.union(x, y)) {
                res += weight;
                edgeCounted++;
            }
        }
        return res;
    }
}
