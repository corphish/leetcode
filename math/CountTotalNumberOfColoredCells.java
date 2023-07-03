// https://leetcode.com/problems/count-total-number-of-colored-cells
class Solution {
    public long coloredCells(int n) {
        return 1L + ((n - 1) * (8 + (n - 2) * 4L))/2;
    }
}