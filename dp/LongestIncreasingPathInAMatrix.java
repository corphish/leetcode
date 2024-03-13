// https://leetcode.com/problems/longest-increasing-path-in-a-matrix
class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        int[][] access = new int[m][n];
        int max = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] == 0) {
                    max = Math.max(dfs(matrix, access, dp, i, j), max);
                }
            }
        }

        return max;
    }

    void print(int[][] arr, int i, int j) {
        System.out.println("At " + i + ", " + j);
        for (int[] row: arr) System.out.println(Arrays.toString(row));
    }

    int dfs(
        int[][] arr,
        int[][] access,
        int[][] dp,
        int i, int j
    ) {
        // We will make sure that i and j are valid before calling this
        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        access[i][j] = 1;

        int len = 1;
        if (safeGet(arr, i, j + 1, -1) > arr[i][j] && safeGet(access, i, j + 1, 1) == 0) {
            len = Math.max(len, 1 + dfs(arr, access, dp, i, j + 1));
        }

        if (safeGet(arr, i, j - 1, -1) > arr[i][j] && safeGet(access, i, j - 1, 1) == 0) {
            len = Math.max(len, 1 + dfs(arr, access, dp, i, j - 1));
        }

        if (safeGet(arr, i + 1, j, -1) > arr[i][j] && safeGet(access, i + 1, j, 1) == 0) {
            len = Math.max(len, 1 + dfs(arr, access, dp, i + 1, j));
        }

        if (safeGet(arr, i - 1, j, -1) > arr[i][j] && safeGet(access, i - 1, j, 1) == 0) {
            len = Math.max(len, 1 + dfs(arr, access, dp, i - 1, j));
        }

        dp[i][j] = len;
        access[i][j] = 0;

        return len;
    }

    int safeGet(int[][] arr, int i, int j, int def) {
        return i < 0 || i >= arr.length || j < 0 || j >= arr[0].length ? def : arr[i][j];
    }
}