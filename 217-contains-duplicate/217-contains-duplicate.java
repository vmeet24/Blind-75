class Solution {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> res = new HashSet<>();
        for (Integer integer : nums) {
            if (res.contains(integer)) {
                return true;
            }
            res.add(integer);
        }
        return false;
    }
}
