// https://leetcode.com/problems/painting-a-grid-with-three-different-colors/
class Solution {
    // Colors:
    // 0 - unset
    // 1 - red
    // 2 - color
    // 3 - blue
    int mod = 1000000007;
    public int colorTheGrid(int m, int n) {
        return count(m, n, 0, 0, 0, new HashMap<>());
        /*int[][][] dp = new int[1024][n + 1][m + 1];
        int mod = 1000000007;

        for (int state = 1023; state >= 0; state -= 1) {
            for (int i = n; i >= 0; i -= 1) {
                for (int j = m; j >= 0; j -= 1) {
                    if (i == n) {
                        dp[state][i][j] = 1;
                    } else if (j == m) {
                        dp[state][i][j] = dp[state][i + 1][0];
                    } else {
                        int count = 0;
                        int left = 0;
                        int top = 0;

                        // Get the color to the left of this cell
                        left = getColor(state, j);

                        // If top is available
                        if (j > 0) {
                            top = getColor(state, j - 1);
                        }

                        for (int color = 1; color <= 3; color += 1) {
                            if (color != left && color != top) {
                                count += dp[setColor(state, j, color)][i][j + 1];
                                count %= mod;
                            }
                        }

                        dp[state][i][j] = count;
                    }
                }
            }
        }

        return dp[0][0][0];*/
    }

    int count(
        int m, int n,
        int state,
        int i, int j,
        Map<String, Integer> memo
    ) {
        if (i == n) {
            return 1;
        }

        if (j == m) {
            return count(m, n, state, i + 1, 0, memo);
        }

        String key = state + "," + i + "," + j;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int count = 0;
        int left = 0;
        int top = 0;

        // Get the color to the left of this cell
        left = getColor(state, j);

        // If top is available
        if (j > 0) {
            top = getColor(state, j - 1);
        }

        for (int color = 1; color <= 3; color += 1) {
            if (color != left && color != top) {
                count += count(m, n, setColor(state, j, color), i, j + 1, memo);
                count %= mod;
            }
        }

        memo.put(key, count);
        return count;
    }

    // We will use 2 bits to represent color in an index in column
    // If the length of column is m, then the total number of bits to be used
    // is 2 * m.
    // As max m can be 5, total 10 bits will be used
    int getColor(int state, int i) {
        int mask = 3 << (2 * i);
        return (state & mask) >> (2 * i);
    }

    int setColor(int state, int i, int color) {
        state &= ~(3 << (i * 2));       // Clear the 2 bits at index i
        state |= (color & 3) << (i * 2); // Set the new state
        return state;
    }
}