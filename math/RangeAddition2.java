// https://leetcode.com/problems/range-addition-ii
class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        int minM = m, minN = n;

        for (int[] op: ops) {
            minM = Math.min(op[0], minM);
            minN = Math.min(op[1], minN);
        }

        return minM * minN;
    }
}