class Solution {
    public int[] twoSum(int[] nums, int target) {
         Map<Integer, Integer> map = new HashMap<>();
        int x;
        for (int i = 0; i < nums.length; i++) {
            x = target - nums[i];
            if (map.containsKey(x)) {
                return new int[] { i, map.get(x) };
            }
            map.put(nums[i], i);
        }
        return null;
    }
}