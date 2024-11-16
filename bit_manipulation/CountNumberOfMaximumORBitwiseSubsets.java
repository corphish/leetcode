// https://leetcode.com/problems/count-number-of-maximum-bitwise-or-subsets/
class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int max = 0;
        for (int x: nums) {
            max = max | x;
        }

        return count(nums, 0, max, 0);
    }

    int count(
        int[] nums, int i,
        int max, int curr
    ) {
        if (i == nums.length) {
            return curr == max ? 1 : 0;
        }

        // Choose i
        return count(nums, i + 1, max, curr | nums[i]) +
            // Dont choose i
            count(nums, i + 1, max, curr);
    }
}