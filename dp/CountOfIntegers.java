class Solution {
    public int count(String num1, String num2, int min, int max) {
        // int res = f(num2, min, max, 0, 1, 0) - f(num1, min, max, 0, 1, 0);

        int sum = 0;
        for (char c : num1.toCharArray()) {
            sum += c - '0';
        }

        int res = ((dp(num2, min, max) + 1000000007) - dp(num1, min, max)) % 1000000007;

        return res + (sum >= min && sum <= max ? 1 : 0);
    }

    int dp(
            String n,
            int min, int max) {
        int[][][] dp = new int[n.length() + 1][2][n.length() * 9 + 10];

        for (int i = n.length(); i >= 0; i--) {
            for (int restricted = 0; restricted < 2; restricted++) {
                for (int sum = n.length() * 9; sum >= 0; sum--) {
                    if (i == n.length()) {
                        dp[i][restricted][sum] = sum >= min && sum <= max ? 1 : 0;
                    } else {
                        long count = 0;

                        if (restricted == 1) {
                            for (int j = 0; j <= n.charAt(i) - '0'; j++) {
                                count += dp[i + 1][j < n.charAt(i) - '0' ? 0 : 1][sum + j] % 1000000007;
                            }
                        } else {
                            for (int j = 0; j <= 9; j++) {
                                count += dp[i + 1][0][sum + j] % 1000000007;
                            }
                        }

                        dp[i][restricted][sum] = (int) (count % 1000000007);
                    }
                }
            }
        }

        return dp[0][1][0];
    }

    int f(
            String n,
            int min, int max,
            int i,
            int restricted,
            int sum) {
        if (i == n.length()) {
            return sum >= min && sum <= max ? 1 : 0;
        }

        int count = 0;

        if (restricted == 1) {
            for (int j = 0; j <= n.charAt(i) - '0'; j++) {
                count += f(n, min, max, i + 1, j < n.charAt(i) - '0' ? 0 : 1, sum + j);
            }
        } else {
            for (int j = 0; j <= 9; j++) {
                count += f(n, min, max, i + 1, 0, sum + j);
            }
        }

        return count;
    }
}