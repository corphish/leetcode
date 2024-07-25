// https://leetcode.com/problems/pass-the-pillow
class Solution {
    public int passThePillow(int n, int time) {
        int dir = 1, k = 1;
        while (time-- > 0) {
            k += dir;
            if (k > n) {
                k = n - 1;
                dir = -1;
            } else if (k == 0) {
                k = 2;
                dir = 1;
            }
        }

        return k;
    }
}