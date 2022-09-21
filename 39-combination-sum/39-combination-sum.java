class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        combinationSumHelper(candidates, target, res, new String(), 0, candidates.length - 1);
        return res;
    }

    void combinationSumHelper(int[] candidates, int target, List<List<Integer>> res, String currList, int currSum, int n) {
        if (n == -1 || currSum > target) {
            return;
        }

        if (currSum == target) {
            String[] r = currList.split(" ");
            List<Integer> it = new ArrayList<>();
            for (int i = 1; i < r.length; i++) {
                try {
                    it.add(Integer.parseInt(r[i]));
                } catch (Exception e) {
                    continue;
                }
            }
            res.add(it);
        } else if (currSum < target) {
            combinationSumHelper(candidates, target, res, currList + " " + candidates[n], currSum + candidates[n], n);
            combinationSumHelper(candidates, target, res, currList, currSum, n - 1);
        }
    }
}
