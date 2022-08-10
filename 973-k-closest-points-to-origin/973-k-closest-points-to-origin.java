class Solution {

    public int[][] kClosest(int[][] points, int k) {
        int[][] ans = new int[k][2];
        PriorityQueue<Coordinates> pq = new PriorityQueue<>(
            new Comparator<Coordinates>() {

                @Override
                public int compare(Coordinates o1, Coordinates o2) {
                    return o1.compareEuclideanDistance(o2);
                }
            }
        );

        for (int i = 0; i < points.length; i++) {
            Coordinates c = new Coordinates(points[i][0], points[i][1]);
            pq.add(c);
        }
        for (int i = 0; i < k; i++) {
            Coordinates c = pq.poll();
            ans[i][0] = c.x;
            ans[i][1] = c.y;
        }
        return ans;
    }
}

class Coordinates {
    int x;
    int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    int compareEuclideanDistance(Coordinates o2) {
        double distance1 = Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2));
        double distance2 = Math.sqrt(Math.pow(o2.x, 2) + Math.pow(o2.y, 2));
        if (distance1 < distance2) {
            return -1;
        } else if (distance1 > distance2) {
            return 1;
        }
        return 0;
    }
}
