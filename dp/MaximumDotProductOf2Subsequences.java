// https://leetcode.com/problems/max-dot-product-of-two-subsequences
class Solution {
    final int MIN = -2000;
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int[][] memo = new int[nums1.length][nums2.length];

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                memo[i][j] = MIN;
            }
        }

        return max(nums1, nums2, 0, 0, memo);
    }

    int max(int[] nums1, int[] nums2, int i, int j, int[][] memo) {
        if (i >= nums1.length || j >= nums2.length) {
            return MIN;
        }

        if (memo[i][j] != MIN) {
            return memo[i][j];
        }

        int product = MIN;
        for (int k = j; k < nums2.length; k++) {
            int t = max(nums1, nums2, i + 1, k + 1, memo);
            int dot = nums1[i] * nums2[k];
            product = Math.max(product, Math.max(dot, dot + (t == MIN ? 0 : t)));
        }

        product = Math.max(product, max(nums1, nums2, i + 1, j, memo));
        return memo[i][j] = product;
    }
}