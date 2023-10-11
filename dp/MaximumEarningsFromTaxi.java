// https://leetcode.com/problems/maximum-earnings-from-taxi
class Solution {
    public long maxTaxiEarnings(int n, int[][] rides) {
        Arrays.sort(rides, (a, b) -> a[0] == b[0] ? a[1] == b[1] ? b[2] - a[2] : a[1] - b[1] : a[0] - b[0]);
        long[] memo = new long[rides.length];
        return max(rides, 0, memo);
    }

    long max(int[][] rides, int i, long[] memo) {
        if (i >= rides.length) {
            return 0L;
        }

        if (memo[i] != 0) {
            return memo[i];
        }

        int start = i;
        for (; start < rides.length; start++) {
            if (rides[start][0] >= rides[i][1]) {
                break;
            }
        }

        long max = Math.max(
            max(rides, i + 1, memo),
            rides[i][1] - rides[i][0] + rides[i][2] + max(rides, start, memo)
        );

        memo[i] = max;
        return max;
    }
}