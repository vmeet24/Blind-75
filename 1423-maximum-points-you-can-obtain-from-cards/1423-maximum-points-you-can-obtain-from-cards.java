class Solution {

    public int maxScore(int[] cardPoints, int k) {
        int sum = IntStream.of(cardPoints).sum();
        int remainingLength = cardPoints.length - k;
        int subArrSum = 0;
        for (int i = 0; i < remainingLength; i++) {
            subArrSum += cardPoints[i];
        }

        int min = subArrSum;
        for (int i = remainingLength; i < cardPoints.length; i++) {
            subArrSum += cardPoints[i];
            subArrSum -= cardPoints[i - remainingLength];
            min = Math.min(subArrSum, min);
        }
        return sum - min;
    }
    
    
}
