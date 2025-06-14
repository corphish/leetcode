// https://leetcode.com/problems/sum-of-good-numbers/
class Solution {
    public int sumOfGoodNumbers(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            boolean res = true;
            if (i - k >= 0 && nums[i - k] >= nums[i]) {
                res = false;
            }

            if (i + k < nums.length && nums[i + k] >= nums[i]) {
                res = false;
            }

            if (res) {
                sum += nums[i];
            }
        }

        return sum;
    }
}