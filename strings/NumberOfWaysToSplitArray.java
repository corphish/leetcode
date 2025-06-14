// https://leetcode.com/problems/number-of-ways-to-split-array
class Solution {
    public int waysToSplitArray(int[] nums) {
        long right = 0, left = 0;
        for (int x: nums) {
            right += x;
        }

        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            left += nums[i];
            right -= nums[i];

            if (left >= right) {
                count += 1;
            }
        }

        return count;
    }
}