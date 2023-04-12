// https://leetcode.com/problems/minimum-cost-for-tickets/
class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[391];
        int day = 0;

        for (int i = 0; i < dp.length; i++) {
            if (day < days.length && i == days[day]) {
                dp[i] = Math.min(
                    costs[0] + dp[i - 1],
                    Math.min(costs[1] + safeGet(dp, i - 7), costs[2] + safeGet(dp, i - 30))
                );

                day++;
            } else {
                if (i > 0) {
                    dp[i] = Math.min(
                        dp[i - 1],
                        Math.min(
                            costs[0] + safeGet(dp, i - 1),
                            Math.min(costs[1] + safeGet(dp, i - 7), costs[2] + safeGet(dp, i - 30))
                        )
                    );
                }
            }
        }

        return dp[dp.length - 1];
    }

    int safeGet(int[] arr, int ix) {
        if (ix < 0) return Integer.MAX_VALUE/2;
        return arr[ix];
    }
}