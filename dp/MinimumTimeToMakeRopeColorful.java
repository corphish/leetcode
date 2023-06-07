// https://leetcode.com/problems/minimum-time-to-make-rope-colorful
class Solution {
    public int minCost(String colors, int[] neededTime) {
        int n = colors.length();

        // dp[i] tells the min time needed to make it colorful
        int[] dp = new int[n];
        int last = 0;

        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1];

            if (colors.charAt(i) != colors.charAt(i - 1)) {
                last = i;
                continue;
            }
            
            if (neededTime[i] < neededTime[last]) {
                dp[i] += neededTime[i];
            } else {
                dp[i] += neededTime[last];
                last = i;
            }
        }

        return dp[n - 1];
    }
}