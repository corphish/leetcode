// https://leetcode.com/problems/stone-game-ii/
class Solution {
    final int INF = Integer.MAX_VALUE/3;
    public int stoneGameII(int[] piles) {
        int[] suffix = piles.clone();
        for (int i = piles.length - 2; i >= 0; i--) {
            suffix[i] += suffix[i + 1];
        }

        return min(suffix, 0, 1, new int[piles.length][piles.length]);
    }

    int min(
        int[] arr,
        int i, int m,
        int[][] memo
    ) {
        if (i >= arr.length) {
            return INF;
        }

        if (i + 2 * m >= arr.length) {
            return arr[i];
        }

        if (memo[i][m] != 0) {
            return memo[i][m];
        }

        int res = INF;
        for (int j = 0; j < 2 * m; j++) {
            res = Math.min(
                res,
                min(arr, i + j + 1, Math.max(j + 1, m), memo)
            );
        }

        return memo[i][m] = arr[i] - res;
    }
}