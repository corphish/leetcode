// https://leetcode.com/problems/count-all-possible-routes
class Solution {
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        long[][] dp = new long[locations.length][fuel + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return count(locations, start, finish, fuel, dp);
    }

    int count(int[] arr, int pos, int finish, int fuel, long[][] dp) {
        if (dp[pos][fuel] != -1) {
            return (int) dp[pos][fuel];
        }

        long c = pos == finish ? 1 : 0;
        for (int i = 0; i < arr.length; i++) {
            if (i != pos) {
                if (Math.abs(arr[pos] - arr[i]) <= fuel) {
                    c += count(arr, i, finish, fuel - Math.abs(arr[pos] - arr[i]), dp);
                }
            }
        }

        dp[pos][fuel] = c % 1000000007;

        return (int) dp[pos][fuel];
    }
}