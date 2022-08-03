class Solution {
    public int totalFruit(int[] fruits) {
        int i = 0;
        int j = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        int max = 0;
        while (j < fruits.length) {
            mp.put(fruits[j], mp.get(fruits[j]) == null ? j : j);
            if (mp.size() > 2) {
                int lastSeen = Collections.min(mp.values());
                mp.remove(fruits[lastSeen]);
                i = lastSeen + 1;
            }
            max = Math.max(max, j - i + 1);
            j++;
        }
        return max;
    }
}