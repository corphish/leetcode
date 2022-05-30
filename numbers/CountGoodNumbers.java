// https://leetcode.com/problems/count-good-numbers
class Solution {
    public int countGoodNumbers(long n) {
        // 1 2  3   4   5    6    7    8
        // 5 20 100 400 2000 8000 40000 16000
        // f(2) = f(1) * 4^1 * 5^0
        // f(3) = f(1) * 4^1 * 5^1
        // f(6) = f(1) * 4^3 * 5^2
        return n == 1 ? 5 : (int) ((5 * modPow(4, n/2) * modPow(5, n/2 - (n % 2 == 0 ? 1 : 0))) % 1000000007);
    }
    
    long modPow(long b, long r) {
        long p = 1;
        while (r > 0) {
            if (r % 2 == 1) {
                p = (p * b) % 1000000007;
            }
            b = (b * b) % 1000000007;
            r /= 2;
        }
        
        return p;
    }
}