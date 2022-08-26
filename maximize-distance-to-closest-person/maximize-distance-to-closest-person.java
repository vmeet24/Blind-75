class Solution {
    public int maxDistToClosest(int[] seats) {
        int i = 0;
        int max = 0;
        int maxSoFar = 0;
        int j = 0;
        while (seats[j] == 0) {
            j++;
        }
        i = j;
        while (i < seats.length) {
            if (seats[i] == 0) {
                maxSoFar++;
            } else {
                maxSoFar = 0;
            }
            max = Math.max(max, maxSoFar);
            i++;
        }
        if (j >= (max / 2) + 1 && j >= maxSoFar) {
            return j;
        } else if (maxSoFar > 0 && maxSoFar >= (max / 2) + 1) {
            return maxSoFar;
        } else {
            return max % 2 == 0 ? (max / 2) : (max / 2) + 1;
        }
    }
}