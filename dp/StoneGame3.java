// https://leetcode.com/problems/stone-game-iii
class Solution {
    public String stoneGameIII(int[] arr) {
        int[] dp = new int[arr.length];
        Arrays.fill(dp, Integer.MIN_VALUE);
        int x = score(arr, 0, dp);
        return x > 0 ? "Alice" : x < 0 ? "Bob" : "Tie";
    }

    int score(int[] arr, int i, int[] dp) {
        if (i >= arr.length) {
            return 0;
        }

        if (dp[i] != Integer.MIN_VALUE) {
            return dp[i];
        }

        int sum = 0;
        int score = Integer.MIN_VALUE;
        for (int j = 1; j <= 3; j++) {
            if (i + j - 1>= arr.length) break;
            sum += arr[i + j - 1];
            score = Math.max(score, sum - score(arr, i + j, dp));
        }

        dp[i] = score;

        return score;
    }
}