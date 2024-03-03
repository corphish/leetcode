// https://leetcode.com/problems/largest-number-at-least-twice-of-others/
class Solution {
    public int dominantIndex(int[] nums) {
        int[] arr = nums.clone();
        Arrays.sort(nums);
        if (nums[nums.length - 1] < 2 * nums[nums.length - 2]) {
            return -1;
        }

        for (int i = 0 ; i < arr.length; i++) {
            if (arr[i] == nums[nums.length - 1]) {
                return i;
            }
        }

        return -1;
    }
}