// https://leetcode.com/problems/uncrossed-lines
class Solution {
    // Recursion + Memo
    /*public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length][nums2.length];
        for (int[] row: dp) Arrays.fill(row, -1);

        return lines(nums1, nums2, 0, 0, dp);
    }*/

    // Tabulation
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        
        for (int i = nums1.length - 1; i >= 0; i--) {
            for (int j = nums2.length - 1; j >= 0; j--) {
                int val = dp[i + 1][j + 1];
                if (nums1[i] == nums2[j]) {
                    val = 1 + dp[i + 1][j + 1];
                }

                dp[i][j] = Math.max(val, Math.max(dp[i][j + 1], dp[i + 1][j]));
            }
        }

        return dp[0][0];
    }
    
    int lines(int[] nums1, int[] nums2, int i, int lastJConnected, int[][] dp) {
        if (i >= nums1.length || lastJConnected >= nums2.length) {
            return 0;
        }

        if (dp[i][lastJConnected] != -1) {
            return dp[i][lastJConnected];
        }

        // We will try to connect nums1[i] with earliest possible index of nums2.
        // That would be one decision, other one would be to not connect them
        int index = -1;
        for (int j = lastJConnected; j < nums2.length; j++) {
            if (nums2[j] == nums1[i]) {
                index = j;
                break;
            }
        }

        int val = 0;
        if (index != -1) {
            // Connect i and index
            val = 1 + lines(nums1, nums2, i + 1, index + 1, dp);
        }

        // Dont connect
        return dp[i][lastJConnected] = Math.max(val, lines(nums1, nums2, i + 1, lastJConnected, dp));
    }
}