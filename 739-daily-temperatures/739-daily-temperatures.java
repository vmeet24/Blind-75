class Solution {

    class Pair {
        Integer key;
        Integer idx;

        public Pair(Integer key, Integer idx) {
            this.key = key;
            this.idx = idx;
        }
    }

    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Pair> stack = new Stack<>();
        int[] res = new int[temperatures.length];
        stack.add(new Pair(temperatures[0], 0));
        for (int i = 1; i < temperatures.length; i++) {
            if (!stack.isEmpty() && temperatures[i] > stack.peek().key) {
                while (!stack.isEmpty() && temperatures[i] > stack.peek().key) {
                    int idx = stack.pop().idx;
                    res[idx] = i - idx;
                }
            }
            stack.add(new Pair(temperatures[i], i));
        }

        return res;
    }
}
