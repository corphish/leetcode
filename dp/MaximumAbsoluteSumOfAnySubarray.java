// https://leetcode.com/problems/maximum-absolute-sum-of-any-subarray/
class Solution {
    public int maxAbsoluteSum(int[] nums) {
        return Math.max(kad(nums, 1), kad(nums, -1));
    }

    int kad(int[] nums, int m) {
        int max = 0, bestMax = 0;
        for (int x: nums) {
            max = Math.max(0, x * m + max);
            bestMax = Math.max(bestMax, max); 
        }

        return bestMax;
    }
}