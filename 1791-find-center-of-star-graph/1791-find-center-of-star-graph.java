class Solution {

    public int findCenter(int[][] edges) {
        return edges[0][0] == edges[1][0] ? edges[0][0] : edges[0][0] == edges[1][1] ? edges[0][0] : edges[0][1];
        //         int[][] arr = new int[edges.length + 2][2];
        //         for (int i = 0; i < edges.length; i++) {
        //             //out-degree
        //             arr[edges[i][0]][0] += 1;
        //             //in-degree
        //             arr[edges[i][1]][1] += 1;
        //         }

        //         for (int i = 1; i < arr.length; i++) {
        //             if (arr[i][1] + arr[i][0] == edges.length) {
        //                 return i;
        //             }
        //         }
        //         return -1;
    }
}
