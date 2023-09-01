// https://leetcode.com/problems/stone-game/
class Solution {
    public boolean stoneGame(int[] piles) {
        int[] points = new int[2];
        int[][][] dp = new int[2][piles.length][piles.length];
        return check(piles, 0, piles.length - 1, points, 0, dp);
    }

    boolean check(
        int[] piles, 
        int l, 
        int r,
        int[] points,
        int player,
        int[][][] dp
    ) {
        if (l > r) {
            return points[0] > points[1];
        }

        if (dp[player % 2][l][r] != 0) {
            return dp[player % 2][l][r] == 1;
        }

        boolean res = false;
        points[player % 2] += piles[l];

        res |= check(piles, l + 1, r, points, player + 1, dp);

        points[player % 2] -= piles[l];
        points[player % 2] += piles[r];

        res |= check(piles, l, r - 1, points, player + 1, dp);
        points[player % 2] -= piles[r];

        dp[player % 2][l][r] = res ? 1 : 2;
        return res;
    }
}