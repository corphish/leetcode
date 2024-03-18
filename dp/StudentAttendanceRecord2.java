// https://leetcode.com/problems/student-attendance-record-ii/
class Solution {
    public int checkRecord(int n) {
        int[][][] dp = new int[n + 1][2][3];
        for (int i = n; i >= 0; i--) {
            for (int a = 1; a >= 0; a--) {
                for (int l = 0; l < 3; l++) {
                    if (i == n) {
                        dp[i][a][l] = 1;
                        continue;
                    }

                    int count = 0;
                    if (l < 2) {
                        // Put P
                        count += dp[i + 1][a][0];
                        count %= 1000000007;

                        // Put L
                        count += dp[i + 1][a][l + 1];
                        count %= 1000000007;

                        // Put A
                        if (a == 1) {
                            count += dp[i + 1][a - 1][0];
                            count %= 1000000007;
                        }
                    } else {
                        // Put P
                        count += dp[i + 1][a][0];
                        count %= 1000000007;

                        // Put A
                        if (a == 1) {
                            count += dp[i + 1][a - 1][0];
                            count %= 1000000007;
                        }
                    }

                    dp[i][a][l] = count;
                }
            }
        }

        return dp[0][1][0];
        // return count(n, 0, 1, 0, new Stack<>());
    }

    int count(int n, int i, int a, int l, Stack<Character> stack) {
        if (i == n) {
            System.out.println(stack);
            return 1;
        }

        int count = 0;
        if (l < 2) {
            // Put P
            stack.push('P');
            count += count(n, i + 1, a, 0, stack);
            stack.pop();

            // Put L
            stack.push('L');
            count += count(n, i + 1, a, l + 1, stack);
            stack.pop();

            // Put A
            if (a == 1) {
                stack.push('A');
                count += count(n, i + 1, a - 1, 0, stack);
                stack.pop();
            }
        } else {
            // Put P
            stack.push('P');
            count += count(n, i + 1, a, 0, stack);
            stack.pop();

            // Put A
            if (a == 1) {
                stack.push('A');
                count += count(n, i + 1, a - 1, 0, stack);
                stack.pop();
            }
        }

        return count;
    }
}