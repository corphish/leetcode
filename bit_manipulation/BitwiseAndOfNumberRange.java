// https://leetcode.com/problems/bitwise-and-of-numbers-range
class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        if (right >= 2L * left) {
            return 0;
        }

        if (left == right) {
            return left;
        }

        if (left == 0 || right == 0) {
            return 0;
        }

        if (power2(left) == power2(right)) {
            int k = power2(left);
            return k + rangeBitwiseAnd(left - k, right - k);
        }

        int res = left;
        for (int i = left + 1; i <= right; i++) {
            res = res & i;
        }

        return res;
    }

    int power2(int x) {
        return 1 << ((int) (Math.log(x)/Math.log(2)));
    }
}