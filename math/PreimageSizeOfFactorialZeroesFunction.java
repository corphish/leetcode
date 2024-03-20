// https://leetcode.com/problems/preimage-size-of-factorial-zeroes-function
// Steps:
// 0. For a given k, we have to estimate x, where x! has k zeroes in end.
// 1. Estimate n, such that 5^n > x, a big value of n can work, like > 32.
// 2. Now estimate x, for that: k = x/5 + x/5^2 + x/5^3 + ... + x/5^n
//    Solving the equation, we get x = (4 * k * 5^n)/(5^n - 1)
// 3. Now we test certain values around x (100 lesser values than x, 100 greater values than x, and x)
//    In the test, we try to find the number of trailing zeroes of the values, if we find a match with k, we return 5
//    because atmost 5 values can have factorial values having k zeroes in the end. If no match, we return 0. 
class Solution {
    public int preimageSizeFZF(int k) {
        int n = (int) (Math.log(Long.MAX_VALUE) / Math.log(5));
        long x = (long) x(k, n);

        for (long i = Math.max(1, x - 100); i <= x + 100; i++) {
            if (zeroCount(i) == k) {
                return 5;
            }
        }

        return 0;
    }

    double x(int k, int n) {
        return Math.ceil(Math.pow(5, n) * 4 * k) / (Math.pow(5, n) - 1);
    }

    long zeroCount(long x) {
        long count = 0;
        long p = 5;
        while (p <= x) {
            count += x / p;
            p *= 5;
        }

        return count;
    }
}