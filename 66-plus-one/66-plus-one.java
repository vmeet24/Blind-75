class Solution {

    public int[] plusOne(int[] digits) {
        int add = 1;
        int carry = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = digits[i] + add + carry;
            if (sum > 9) {
                carry = sum / 10;
                int unit = sum % 10;
                digits[i] = unit;
                add = 0;
            } else {
                digits[i] = sum;
                return digits;
            }
        }
        int[] digitsV1 = new int[digits.length + 1];
        digitsV1[0] = carry;
        for (int i = 1; i < digitsV1.length; i++) {
            digitsV1[i] = digits[i - 1];
        }
        return digitsV1;
    }
}
