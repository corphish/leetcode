// https://leetcode.com/problems/find-closest-person/submissions/1611629496/
class Solution {
    public int findClosest(int x, int y, int z) {
        x = Math.abs(z - x);
        y = Math.abs(z - y);

        return x == y ? 0 : x < y ? 1 : 2;
    }
}