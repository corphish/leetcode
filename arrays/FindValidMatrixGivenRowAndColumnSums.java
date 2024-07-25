// https://leetcode.com/problems/find-valid-matrix-given-row-and-column-sums
class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int m = rowSum.length, n = colSum.length;
        int[][] rows = new int[m][2];
        int[][] cols = new int[n][2];

        for (int i = 0; i < m; i++) {
            rows[i][0] = rowSum[i];
            rows[i][1] = i;
        }

        for (int i = 0; i < n; i++) {
            cols[i][0] = colSum[i];
            cols[i][1] = i;
        }

        int[][] res = new int[m][n];

        Arrays.sort(rows, (a, b) -> a[0] - b[0]);
        Arrays.sort(cols, (a, b) -> a[0] - b[0]);

        int rowPtr = 0, colPtr = 0;
        int count = 0;

        while (count < m * n) {
            if (rowPtr >= m && colPtr >= n) break;

            if (rows[rowPtr][0] < cols[colPtr][0]) {
                res[rows[rowPtr][1]][cols[colPtr][1]] = rows[rowPtr][0];
                cols[colPtr][0] -= rows[rowPtr][0];
                rowPtr += 1;
            } else if (rows[rowPtr][0] > cols[colPtr][0]) {
                res[rows[rowPtr][1]][cols[colPtr][1]] = cols[colPtr][0];
                rows[rowPtr][0] -= cols[colPtr][0];
                colPtr += 1;
            } else {
                res[rows[rowPtr][1]][cols[colPtr][1]] = cols[colPtr][0];
                colPtr += 1;
                rowPtr += 1;
                count += 1;
            }

            count += 1;
        }

        return res;
    }
}