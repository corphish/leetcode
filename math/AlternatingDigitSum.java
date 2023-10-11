// https://leetcode.com/problems/alternating-digit-sum/
class Solution {
    public int alternateDigitSum(int n) {
        int k1 = 1, k2 = -1;
        int s1 = 0, s2 = 0;
        int count = 0;

        while (n > 0) {
            int r = n % 10;
            s1 += r * k1;
            s2 += r * k2;

            k1 *= -1;
            k2 *= -1;

            count += 1;
            n /= 10;
        }

        return count % 2 == 0 ? s2 : s1;
    }
}