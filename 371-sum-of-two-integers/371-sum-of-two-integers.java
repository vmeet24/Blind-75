class Solution {

    public int getSum(int a, int b) {
        while (b != 0) {
            // Storing this value in temp variable so that b doesnt get the updated value of a while doing XOR operation.
            int tmp = (a & b) << 1;
            a = a ^ b;
            b = tmp;
        }
        return a;
    }
}
