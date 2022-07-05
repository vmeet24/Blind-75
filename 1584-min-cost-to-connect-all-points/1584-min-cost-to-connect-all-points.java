// class Solution {

//     public int minCostConnectPoints(int[][] points) {
//         List<int[]> lst = new ArrayList<>();

//         for (int i = 0; i < points.length; i++) {
//             for (int j = i + 1; j < points.length; j++) {
//                 int weight = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
//                 int[] node = { weight, i, j };
//                 lst.add(i, node);
//             }
//         }

//         Collections.sort(
//             lst,
//             (x, y) -> {
//                 return Integer.compare(x[0], y[0]);
//             }
//         );

//         int res = 0;
//         int edgeCounted = 0;
//         int[] arr = new int[points.length];
//         Arrays.fill(arr, -1);

//         for (int[] is : lst) {

//             int parent1 = is[1];
//             int value1 = arr[is[1]];
//             while (value1 >= 0) {
//                 parent1 = value1;
//                 value1 = arr[parent1];
//             }

//             int parent2 = is[2];
//             int value2 = arr[is[2]];
//             while (value2 >= 0) {
//                 parent2 = value2;
//                 value2 = arr[parent2];
//             }

//             if (parent1 != parent2) {
//                 res += is[0];
//                 edgeCounted++;
//                 arr[value1 <= value2 ? parent2 : parent1] = value1 <= value2 ? parent1 : parent2;
//                 arr[value1 <= value2 ? parent1 : parent2] = value1 + value2;
//             }
//             if (edgeCounted == arr.length - 1) {
//                 return res;
//             }
//         }
//         return res;
//     }
// }

class UnionFind {
    public int[] group;
    public int[] rank;

    public UnionFind(int size) {
        group = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; ++i) {
            group[i] = i;
        }
    }

    public int find(int node) {
        if (group[node] != node) {
            group[node] = find(group[node]);
        }
        return group[node];
    }

    public boolean union(int node1, int node2) {
        int group1 = find(node1);
        int group2 = find(node2);
        
        // node1 and node2 already belong to same group.
        if (group1 == group2) {
            return false;
        }

        if (rank[group1] > rank[group2]) {
            group[group2] = group1;
        } else if (rank[group1] < rank[group2]) {
            group[group1] = group2;
        } else {
            group[group1] = group2;
            rank[group2] += 1;
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
                
                int[] currEdge = {weight, currNext, nextNext};
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
