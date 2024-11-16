// https://leetcode.com/problems/minimum-total-distance-traveled
class Solution {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        List<Integer> f = new ArrayList<>();

        for (int[] x: factory) {
            for (int i = 0; i < x[1]; i++) {
                f.add(x[0]);
            }
        }

        Collections.sort(robot);
        Collections.sort(f);

        long[][] dp = new long[robot.size() + 1][f.size() + 1];

        for (int i = robot.size(); i >= 0; i--) {
            for (int j = f.size(); j >= 0; j--) {
                if (i == robot.size()) {
                    dp[i][j] = 0;
                } else if (j == f.size()) {
                    dp[i][j] = Long.MAX_VALUE/20000;
                } else {
                    dp[i][j] = Math.min(
                        1L * Math.abs(robot.get(i) - f.get(j)) + dp[i + 1][j + 1],
                        dp[i][j + 1]
                    );
                }
            }
        }

        return dp[0][0];
    }

    long min(
        List<Integer> robot,
        List<Integer> f,
        int i, int j
    ) {
        if (i == robot.size()) {
            return 0;
        }

        if (j == f.size()) {
            return Long.MAX_VALUE/20000;
        }

        return Math.min(
            1L * Math.abs(robot.get(i) - f.get(j)) + min(robot, f, i + 1, j + 1),
            min(robot, f, i, j + 1)
        );
    }
}