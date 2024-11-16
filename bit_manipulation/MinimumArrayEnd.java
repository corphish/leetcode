// https://leetcode.com/problems/minimum-array-end
class Solution {
    public long minEnd(int n, int x) {
        long res = 0;
        int k = n - 1, p = 0;

        for (; k > 0; x >>= 1, p++) {
            long r = k & 1;
            if ((x & 1) == 0) {
                res += r << p;
                k >>= 1;
            } else {
                res += 1 << p;
            }
        }

        res += x << p;

        return res;
    }
}