// https://leetcode.com/problems/minimize-maximum-pair-sum-in-array
class Solution {
    public int minPairSum(int[] nums) {
        int min = Integer.MIN_VALUE;
        
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length; i++) {
            min = Math.max(nums[i] + nums[nums.length - 1 - i], min);
        }
        
        return min;
    }
}