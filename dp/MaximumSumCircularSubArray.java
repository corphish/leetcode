// https://leetcode.com/problems/maximum-sum-circular-subarray/
class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int sum = 0, max = Integer.MIN_VALUE;
        for (int x: nums) {
            sum += x;
            max = Math.max(x, max);
        }

        if (max < 0) return max;

        return Math.max(
            kadaneMax(nums),
            sum - kadaneMin(nums)
        );
    }

    int kadaneMin(int[] nums) {
        int localMin = 0, globalMin = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            localMin = Math.min(nums[i], nums[i] + localMin);
            globalMin = Math.min(localMin, globalMin);
        }

        return globalMin;
    }

    int kadaneMax(int[] nums) {
        int localMax = 0, globalMax = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            localMax = Math.max(nums[i], nums[i] + localMax);
            globalMax = Math.max(localMax, globalMax);
        }

        return globalMax;
    }
}