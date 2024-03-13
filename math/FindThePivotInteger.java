// https://leetcode.com/problems/find-the-pivot-integer/
class Solution {
    public int pivotInteger(int n) {
        int total = (n * (n + 1))/2;
        for (int i = 1; i <= n; i++) {
            int k = (i * (i + 1))/2;
            if (k - i == total - k) {
                return i;
            }
        }

        return -1;
    }
}