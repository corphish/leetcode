// https://leetcode.com/problems/minimum-flips-to-make-a-or-b-equal-to-c/
class Solution {
    public int minFlips(int a, int b, int c) {
        int flips = 0;
        while (a > 0 || b > 0 || c > 0) {
            int ba = a & 1;
            int bb = b & 1;
            int bc = c & 1;

            a >>= 1;
            b >>= 1;
            c >>= 1;

            if ((ba | bb) != bc) {
                if (bc == 0 && ba * bb == 1) {
                    flips += 2;
                } else {
                    flips += 1;
                }
            }
        }

        return flips;
    }
}