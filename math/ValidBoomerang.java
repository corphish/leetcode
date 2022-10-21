// https://leetcode.com/problems/valid-boomerang
class Solution {
    public boolean isBoomerang(int[][] p) {
        return 0.5 * (p[0][0] * (p[1][1] - p[2][1]) + p[1][0] * (p[2][1] - p[0][1]) + p[2][0] * (p[0][1] - p[1][1])) != 0;
    }
}