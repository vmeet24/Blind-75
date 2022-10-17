//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] isVisited = new boolean[V];
        boolean[] isVisitedOnSamePath = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!isVisited[i]) {
                if (checkDFS(i, adj, isVisited, isVisitedOnSamePath)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkDFS(int i, ArrayList<ArrayList<Integer>> adj, boolean[] isVisited,
            boolean[] isVisitedOnSamePath) {
        isVisited[i] = true;
        isVisitedOnSamePath[i] = true;

        for (int j : adj.get(i)) {
            if (!isVisited[j]) {
                if (checkDFS(j, adj, isVisited, isVisitedOnSamePath)) {
                    return true;
                }
            }
            else if (isVisitedOnSamePath[j]) {
                    return true;
                }
        }
        isVisitedOnSamePath[i] = false;
        return false;
    }
}