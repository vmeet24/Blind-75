class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> mp = new HashMap<>();

        int i = 0, j = 0;
        int size = 0;
        int max = 0;
        while (j < fruits.length) {
            int k = fruits[j];
            if (!mp.containsKey(k)) {
                mp.put(k, 1);
                size++;
            } else {
                if (mp.get(k) == 0) {
                    size++;
                }
                mp.put(k, mp.get(k) + 1);
            }

            if (size > 2) {
                while (size > 2) {
                    mp.put(fruits[i], mp.get(fruits[i]) - 1);
                    if (mp.get(fruits[i]) == 0) {
                        size--;
                    }
                    i++;
                }
            }
            max = Math.max(max, j - i + 1);
            j++;
        }
        System.out.println(max);
        return max;
    }
}