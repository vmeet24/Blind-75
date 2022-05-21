class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;
        int minValue = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (minValue > prices[i]) {
                minValue = prices[i];
            } else {
                res = Math.max(res, prices[i] - minValue);
            }
        }
        return res;
    }
}