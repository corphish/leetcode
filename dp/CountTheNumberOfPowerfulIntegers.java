// https://leetcode.com/problems/count-the-number-of-powerful-integers
class Solution {
    public long numberOfPowerfulInt(long start, long finish, int limit, String t) {
        long rs = 0;
        long rf = 0;

        if (Long.parseLong(t) <= start - 1) {
            rs = dp(rangeFor(start - 1, t), limit);
        }

        if (Long.parseLong(t) <= finish) {
            rf = dp(rangeFor(finish, t), limit);
        }

        return rf - rs;
    }

    String rangeFor(long n, String suff) {
        int sub = 0;
        String s = "" + n;

        String sfx = s.substring(s.length() - suff.length());
        String pfx = s.substring(0, s.length() - suff.length());

        if (Long.parseLong(sfx) < Long.parseLong(suff)) {
            sub = 1;
        }

        if (pfx.isEmpty()) {
            return pfx;
        }

        return "" + (Long.parseLong(pfx) - sub);
    }

    long dp(String n, int limit) {
        long[][] dp = new long[n.length() + 1][2];

        for (int i = n.length(); i >= 0; i--) {
            for (int restricted = 0; restricted < 2; restricted++) {
                if (i == n.length()) {
                    dp[i][restricted] = 1;
                } else {
                    long count = 0;
                    if (restricted == 1) {
                        for (int j = 0; j <= Math.min(limit, n.charAt(i) - '0'); j++) {
                            count += dp[i + 1][j < n.charAt(i) - '0' ? 0 : 1];
                        }
                    } else {
                        for (int j = 0; j <= limit; j++) {
                            count += dp[i + 1][0];
                        }
                    }

                    dp[i][restricted] = count;
                }
            }
        }

        return dp[0][1];
    }

    long f(
        String n, int limit,
        int i, int restricted
    ) {
        if (i == n.length()) {
            return 1;
        }

        long count = 0;
        if (restricted == 1) {
            for (int j = 0; j <= Math.min(limit, n.charAt(i) - '0'); j++) {
                count += f(n, limit, i + 1, j < n.charAt(i) - '0' ? 0 : 1);
            }
        } else {
            for (int j = 0; j <= limit; j++) {
                count += f(n, limit, i + 1, 0);
            }
        }

        return count;
    }
}