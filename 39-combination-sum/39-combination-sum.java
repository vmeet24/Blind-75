class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        combinationSumHelper(candidates, target, res, curr, 0, candidates.length - 1);
        return res;
    }

    void combinationSumHelper(int[] candidates, int target, List<List<Integer>> res, List<Integer> currList, int currSum, int n) {
        if (n == -1 || currSum > target) {
            return;
        }

        if (currSum == target) {
            res.add(new ArrayList<>(currList));
        } else if (currSum < target) {
            currList.add(candidates[n]);
            combinationSumHelper(candidates, target, res, currList, currSum + candidates[n], n);
            currList.remove(currList.size() - 1);
            combinationSumHelper(candidates, target, res, currList, currSum, n - 1);
        }
    }
}
