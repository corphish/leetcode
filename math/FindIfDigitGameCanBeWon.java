// https://leetcode.com/problems/find-if-digit-game-can-be-won/
class Solution {
    public boolean canAliceWin(int[] nums) {
        int s = 0, d = 0;
        for (int x: nums) {
            if (x < 10) s += x;
            else d += x;
        }

        return s != d;
    }
}