// https://leetcode.com/problems/number-of-ways-to-divide-a-long-corridor/
class Solution {
    final int mod = 1000000007;
    public int numberOfWays(String S) {
        boolean isCounting = false;
        long count = 1, k = 0;
        int s = 0, tot = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == 'P') {
                if (isCounting) {
                    k += 1;
                }
            } else {
                tot += 1;
                if (isCounting) {
                    count *= k + 1;
                    count %= mod;
                    k = 0;
                    isCounting = false;
                    s = 1;
                } else {
                    s += 1;
                    if (s == 2) {
                        isCounting = true;
                    }
                }
            }
        }

        if (tot == 0 || tot % 2 == 1) {
            return 0;
        }

        return (int) (count % mod);
    }

    // Works but TLEs on last case
    int DP(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        char[] arr = s.toCharArray();
        
        for (int start = n; start >= 0; start--) {
            if (start == n) {
                dp[start] = 1;
            }

            int S = 0;
            for (int i = start; i < arr.length; i++) {
                if (arr[i] == 'S') {
                    S += 1;
                }

                if (S == 2) {
                    dp[start] += dp[i + 1];
                    dp[start] %= mod;
                }

                if (S == 3) {
                    break;
                }
            }
        }

        return dp[0];
    }
}