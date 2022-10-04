class Solution {

    public int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (visited[i] == false) {
                stack.push(i);
                res++;
                while (!stack.isEmpty()) {
                    int j = stack.peek();
                    visited[j] = true;
                    int unvisited = -1;
                    for(int k = 0; k<isConnected[j].length;k++){
                        if(isConnected[j][k] == 1 && visited[k] == false){
                            unvisited = k;
                            break;
                        }
                    }
                    if(unvisited == -1){
                        stack.pop();
                    }
                    else{
                        stack.push(unvisited);
                    }
                }
            }
        }
        return res;
    }
}
