// https://leetcode.com/problems/maximum-value-of-k-coins-from-piles
class Solution {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int[][] memo = new int[piles.size() + 1][k + 1];
        for (int[] row: memo) {
            Arrays.fill(row, -1);
        }
        return max(piles, k, piles.size(), memo);
    }

    int max(List<List<Integer>> piles, int k, int i, int[][] memo) {
        if (i == 0) {
            return 0;
        }

        if (memo[i][k] != -1) {
            return memo[i][k];
        }

        int sum = 0;
        for (int j = 0; j <= Math.min(piles.get(i - 1).size(), k); j++) {
            if (j > 0) {
                sum += piles.get(i - 1).get(j - 1);
            }
            memo[i][k] = Math.max(memo[i][k], max(piles, k - j, i - 1, memo) + sum);
        }

        return memo[i][k];
    }
}