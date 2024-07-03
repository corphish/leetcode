// https://leetcode.com/problems/freedom-trail
class Solution {
    public int findRotateSteps(String ring, String key) {
        int[][][] memo = new int[key.length()][ring.length()][3];
        return min(ring, key, 0, 0, 0, memo);
    }

    int min(
        String ring,
        String key,
        int i, // key index
        int j, // ring index
        int last, // 0 - button press, 1 - clockwise, 2 - anticlockwise,
        int[][][] memo
    ) {
        if (i >= key.length()) {
            return 0;
        }

        if (memo[i][j][last] != 0) {
            return memo[i][j][last];
        }

        int res = Integer.MAX_VALUE;

        if (key.charAt(i) == ring.charAt(j)) {
            res = 1 + min(ring, key, i + 1, j, 0, memo);
        } else {
            int next = (j + 1) % ring.length();
            int prev = j == 0 ? ring.length() - 1 : j - 1;

            if (last == 0) {
                res = Math.min(
                    1 + min(ring, key, i, next, 1, memo),
                    1 + min(ring, key, i, prev, 2, memo)
                );
            } else if (last == 1) {
                res = 1 + min(ring, key, i, next, 1, memo);
            } else {
                res = 1 + min(ring, key, i, prev, 2, memo);
            }
        }

        return memo[i][j][last] = res;
    }
}