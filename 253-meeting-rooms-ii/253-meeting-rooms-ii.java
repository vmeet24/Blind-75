class Solution {
    public int minMeetingRooms(int[][] intervals) {
//         Map<Integer, Integer> start = new HashMap<>();
//         Map<Integer, Integer> end = new HashMap<>();
//         int maxTime = 0;
//         for (int i = 0; i < intervals.length; i++) {
//             if (!start.containsKey(intervals[i][0])) {
//                 start.put(intervals[i][0], 1);
//             } else {
//                 start.put(intervals[i][0], start.get(intervals[i][0]) + 1);
//             }
//             if (!end.containsKey(intervals[i][1])) {
//                 maxTime = Math.max(intervals[i][1], maxTime);
//                 end.put(intervals[i][1], 1);
//             } else {
//                 end.put(intervals[i][1], end.get(intervals[i][1]) + 1);
//             }
//         }

//         int currInUse = 0;
//         int totalConference = 0;
//         for (int i = 0; i <= maxTime; i++) {
//             if (end.containsKey(i)) {
//                 currInUse -= end.get(i);
//             }
//             if (start.containsKey(i)) {
//                 if (totalConference >= currInUse + start.get(i)) {
//                     currInUse += start.get(i);
//                 } else {
//                     totalConference = currInUse + start.get(i);
//                     currInUse += start.get(i);
//                 }
//             }
//         }
//         return totalConference;
        Arrays.sort(intervals, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        Queue<Integer> pq = new PriorityQueue<>();
        pq.add(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {
            if (!pq.isEmpty() && intervals[i][0] >= pq.peek()) {
                pq.poll();
            }
            pq.add(intervals[i][1]);
        }
        System.out.println(pq.size());
        return pq.size();
    }
}