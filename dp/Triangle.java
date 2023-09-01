// https://leetcode.com/problems/triangle
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();

        // Recursive
        /*int[][] memo = new int[n][n];
        for (int[] row: memo) Arrays.fill(row, -10);
        return min(triangle, 0, 0, memo);*/

        int[][] dp = new int[n][n];
        for (int[] row: dp) Arrays.fill(row, Integer.MAX_VALUE);
        dp[0][0] = triangle.get(0).get(0);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                if (j == 0) {
                    dp[i][j] = triangle.get(i).get(j) + dp[i - 1][j];
                } else {
                    dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int x: dp[n - 1]) {
            min = Math.min(min, x);
        }

        return min;
    }

    int min(List<List<Integer>> arr, int i, int j, int[][] memo) {
        if (i == arr.size()) {
            return 0;
        }

        if (j >= arr.get(i).size()) {
            return Integer.MAX_VALUE;
        }

        if (memo[i][j] != -10) {
            return memo[i][j];
        }

        return memo[i][j] = arr.get(i).get(j) + Math.min(
            min(arr, i + 1, j, memo),
            min(arr, i + 1, j + 1, memo)
        );
    }
}