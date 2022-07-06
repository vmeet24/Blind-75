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

        for (int i = 0; i < arrSize; i++) {
            for (int j = i + 1; j < arrSize; j++) {
                int weight = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                int[] node = { weight, i, j };
                lst.add(node);
            }
        }

        Collections.sort(
            lst,
            (x, y) -> {
                return Integer.compare(x[0], y[0]);
            }
        );

        int res = 0;
        int edgeCounted = 0;
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
