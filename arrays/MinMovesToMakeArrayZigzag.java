// https://leetcode.com/problems/decrease-elements-to-make-array-zigzag
class Solution {
    public int movesToMakeZigzag(int[] nums) {
        return Math.min(
            moves(nums, 0),
            moves(nums, 1)
        );
    }

    int moves(int[] nums, int start) {
        int moves = 0;
        for (int i = start; i < nums.length; i += 2) {
            int left = i == 0 ? Integer.MAX_VALUE : nums[i - 1];
            int right = i == nums.length - 1 ? Integer.MAX_VALUE : nums[i + 1];
            if (nums[i] < left && nums[i] < right) {
                continue;
            } else {
                moves += nums[i] - (Math.min(left, right) - 1);
            }
        }

        return moves;
    }
}