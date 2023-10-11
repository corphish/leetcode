// https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero
class Solution {
    public int minOperations(int[] nums, int x) {
        long sum = 0;
        for (int y: nums) sum += y;

        int l = 0, r = 0, max = -1;
        long target = sum - x, rolling = 0;

        for (; l <= r && l < nums.length;) {
            if (rolling == target) {
                max = Math.max(max, r - l);
            }

            if (rolling < target && r < nums.length) {
                rolling += nums[r++];
            } else {
                if (r == l) {
                    if (r == nums.length) {
                        break;
                    }

                    rolling += nums[r++];
                } else {
                    rolling -= nums[l++];
                }
            }
        }

        return max == -1 ? max : nums.length - max;
    }
}