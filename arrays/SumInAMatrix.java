// https://leetcode.com/problems/sum-in-a-matrix/
class Solution {
    public int matrixSum(int[][] nums) {
        for (int[] x: nums) {
            Arrays.sort(x);
        }

        int score = 0;
        for (int j = 0; j < nums[0].length; j++) {
            int max = 0;
            for (int i = 0; i < nums.length; i++) {
                max = Math.max(max, nums[i][j]);
            }
            score += max;
        }

        return score;
    }
}