// https://leetcode.com/problems/minimum-number-game/
class Solution {
    public int[] numberGame(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i += 2) {
            int t = nums[i];
            nums[i] = nums[i - 1];
            nums[i - 1] = t;
        }

        return nums;
    }
}