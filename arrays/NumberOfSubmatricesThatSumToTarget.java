// https://leetcode.com/problems/number-of-submatrices-that-sum-to-target/
class Solution {
    public int numSubmatrixSumTarget(int[][] arr, int target) {
        int m = arr.length, n = arr[0].length;

        for (int j = 0; j < n; j++) {
            for (int i = 1; i < m; i++) {
                arr[i][j] += arr[i - 1][j];
            }
        }

        // horizontal prefixsum
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                arr[i][j] += arr[i][j - 1];
            }
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int x = i; x < m; x++) {
                    for (int y = j; y < n; y++) {
                        int sum = arr[x][y] -
                                (i == 0 ? 0 : arr[i - 1][y]) -
                                (j == 0 ? 0 : arr[x][j - 1]) +
                                (i == 0 || j == 0 ? 0 : arr[i - 1][j - 1]);

                        if (sum == target) {
                            count += 1;
                        }
                    }
                }
            }
        }

        return count;
    }
}