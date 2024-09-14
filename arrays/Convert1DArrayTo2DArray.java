// https://leetcode.com/problems/convert-1d-array-into-2d-array
class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        int l = original.length;

        if (m * n != l) {
            return new int[][] {};
        }

        int[][] res = new int[m][n];
        int k = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = original[k++];
            }
        }

        return res;
    }
}