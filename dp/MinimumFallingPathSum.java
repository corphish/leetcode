// https://leetcode.com/problems/minimum-falling-path-sum
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] min =  new int[n][n];
        int minVal = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            Arrays.fill(min[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < n; i++) {
            minVal = Math.min(minVal, fill(matrix, min, 0, i));
        }

        return minVal;
    }

    int fill(int[][] arr, int[][] min, int i, int j) {
        
        if (i < 0 || j < 0 || i >= arr.length || j >= arr.length) {
            return Integer.MAX_VALUE;
        }

        if (min[i][j] != Integer.MAX_VALUE) {
            return min[i][j];
        }

        if (i == arr.length - 1) {
            min[i][j] = arr[i][j];
            return min[i][j];
        }

        int left = fill(arr, min, i + 1, j - 1);
        int bottom = fill(arr, min, i + 1, j);
        int right = fill(arr, min, i + 1, j + 1);

        min[i][j] = arr[i][j] + Math.min(left, Math.min(bottom, right));
        return min[i][j];
    }
}