// https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element
class Solution {
    public int longestSubarray(int[] nums) {
        int max = 0, n = nums.length;
        int start = 0, lastZero = -1;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                if (lastZero == -1) {
                    lastZero = i;

                    // Skip this one
                    continue;
                } else {
                    // We delete the last zero and check max
                    int len = i - start - 1;
                    max = Math.max(max, len);
                    start = lastZero + 1;
                    lastZero = i;
                }
            }
        }

        int len = n - start - 1;
        max = Math.max(max, len);

        return max;
    }
}