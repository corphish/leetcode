// https://leetcode.com/problems/count-square-submatrices-with-all-ones
class Solution {
    public int countSquares(int[][] matrix) {
        int sum = 0;
        int[][] memo = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1)
                    sum += count(matrix, i, j, memo);
            }
        }
        return sum;
    }

    int count(int[][] arr, int i, int j, int[][] memo) {
        if (i < 0 || j < 0) {
            return 0;
        }

        if (i == arr.length || j == arr[0].length) {
            return 0;
        }

        if (memo[i][j] != 0) {
            return memo[i][j];
        }

        if (arr[i][j] == 0) {
            return 0;
        }

        int count = arr[i][j];
        count += Math.min(
            count(arr, i, j + 1, memo),
            Math.min(count(arr, i + 1, j, memo), count(arr, i + 1, j + 1, memo))
        );

        memo[i][j] = count;
        return count;
    }
}