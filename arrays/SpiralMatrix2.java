// https://leetcode.com/problems/spiral-matrix-ii
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int dir = 0;
        int k = 1, i = 0, j = 0;
        
        for (; k <= n * n; k++) {
            res[i][j] = k;
            if (dir == 0) {
                if (j < n - 1 && res[i][j + 1] == 0) {
                    j++;
                } else {
                    dir++;
                    i++;
                }
            } else if (dir == 1) {
                if (i < n - 1 && res[i + 1][j] == 0) {
                    i++;
                } else {
                    dir++;
                    j--;
                }
            } else if (dir == 2) {
                if (j > 0 && res[i][j - 1] == 0) {
                    j--;
                } else {
                    dir++;
                    i--;
                }
            } else {
                if (i > 0 && res[i - 1][j] == 0) {
                    i--;
                } else {
                    dir = 0;
                    j++;
                }
            }
        }
        
        return res;
    }
}