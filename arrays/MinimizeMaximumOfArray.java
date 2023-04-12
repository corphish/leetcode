// https://leetcode.com/problems/minimize-maximum-of-array
class Solution {
    public int minimizeArrayValue(int[] nums) {
        double res = nums[0], sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
            res = Math.max(res, Math.ceil(sum/(i + 1)));
        }

        return (int) res;
    }
}