// https://leetcode.com/problems/longest-subarray-with-maximum-bitwise-and/
class Solution {
    public int longestSubarray(int[] nums) {
        int max = 0, count = 0, res = 0;

        for (int x: nums) {
            if (x > max) {
                max = x;
                count = 0;
                res = 0;
            }

            if (x == max) {
                count += 1;
            } else {
                count = 0;
            }

            res = Math.max(count, res);
        }

        return res;
    }
}