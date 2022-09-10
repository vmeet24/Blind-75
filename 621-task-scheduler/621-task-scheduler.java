class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < tasks.length; i++) {
            if (map.containsKey(tasks[i])) {
                map.put(tasks[i], map.get(tasks[i]) + 1);
            } else {
                map.put(tasks[i], 1);
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (Integer integer : map.values()) {
            pq.add(integer);
        }

        Queue<int[]> queue = new ArrayDeque<>();
        int time = 0;
        while (!pq.isEmpty() || !queue.isEmpty()) {
            time++;
            if (!pq.isEmpty()) {
                int t = pq.poll() - 1;
                if (t != 0) {
                    queue.add(new int[] { t, time + n });
                }
            }

            if (!queue.isEmpty()) {
                int[] pair = queue.peek();
                if (time == pair[1]) {
                    pq.add(pair[0]);
                    queue.poll();
                }
            }
        }
        System.out.println(time);
        return time;
    }
}