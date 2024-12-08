// https://leetcode.com/problems/maximum-matrix-sum
class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long sum = 0;
        int min = Integer.MAX_VALUE;
        int count = 0;

        for (int[] row : matrix) {
            for (int x : row) {
                sum += Math.abs(x);
                min = Math.min(min, Math.abs(x));
                if (x < 0)
                    count += 1;
            }
        }

        return count % 2 == 0 ? sum : sum - 2 * min;
    }
}