// https://leetcode.com/problems/maximal-square/
class Solution {
    public int maximalSquare(char[][] matrix) {
        int max = 0;
        int[][] memo = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == '1')
                    max = Math.max(max, max(matrix, i, j, memo));
            }
        }
        return max * max;
    }

    int max(
        char[][] arr,
        int i, int j,
        int[][] memo
    ) {
        if (i < 0 || j < 0) {
            return 0;
        }

        if (i == arr.length || j == arr[0].length) {
            return 0;
        }

        if (memo[i][j] != 0) {
            return memo[i][j];
        }

        if (arr[i][j] == '0') {
            return 0;
        }

        int count = Math.min(
            1 + max(arr, i, j + 1, memo),
            Math.min(1 + max(arr, i + 1, j, memo), 1 + max(arr, i + 1, j + 1, memo))
        );

        memo[i][j] = count;
        return count;
    }
}