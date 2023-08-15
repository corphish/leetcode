// https://leetcode.com/problems/powx-n/
class Solution {
    public double myPow(double x, int n) {
        long k = n;
        if (k < 0) {
            x = 1/x;
            k = -k;
        }

        double res = 1;
        while (k > 0) {
            if (k % 2 == 1) {
                res *= x;
            }

            x *= x;
            k /= 2;
        }

        return res;
    }
}