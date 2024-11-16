// https://leetcode.com/problems/maximum-number-of-moves-in-a-grid
class Solution {
    public int maxMoves(int[][] grid) {
        int max = 0;
        int[][] memo = new int[grid.length][grid[0].length];
        for (int a = 0; a < grid.length; a++) {
            max = Math.max(max, max(grid, a, 0, memo));
        }

        return max;
    }

    int max(
        int[][] arr,
        int i, int j,
        int[][] memo
    ) {
        if (i >= arr.length || j >= arr[i].length - 1) {
            return 0;
        }

        if (memo[i][j] != 0) {
            return memo[i][j];
        }

        int max = 0;
        if (i > 0 && arr[i - 1][j + 1] > arr[i][j]) {
            max = Math.max(max, 1 + max(arr, i - 1, j + 1, memo));
        }

        if (i < arr.length - 1 && arr[i + 1][j + 1] > arr[i][j]) {
            max = Math.max(max, 1 + max(arr, i + 1, j + 1, memo));
        }

        if (arr[i][j + 1] > arr[i][j]) {
            max = Math.max(max, 1 + max(arr, i, j + 1, memo));
        }

        return memo[i][j] = max;
    }
}