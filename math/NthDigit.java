// https://leetcode.com/problems/nth-digit/
class Solution {
    public int findNthDigit(int n) {
        if (n < 10) return n;
        long factor = 9, k = 1, last = 0;

        while (n > factor * k) {
            n -= factor * k;
            k += 1;
            last += factor;
            factor *= 10;
        }

        int number = (int) (last + Math.ceil((n * 1.0)/k));
        int x = (int) (n % k == 0 ? k - 1 : (n % k) - 1);
        
        return (int) ((number + "").charAt(x) - '0');
    }
}