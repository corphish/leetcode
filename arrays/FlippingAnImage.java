// https://leetcode.com/problems/flipping-an-image/
class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int n = image.length;
        int[][] res = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = image[i][n - 1 - j];
                res[i][j] = res[i][j] == 1 ? 0 : 1;
            }
        }

        return res;
    }
}