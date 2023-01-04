// https://leetcode.com/problems/minimum-average-difference
class Solution {
    public int minimumAverageDifference(int[] nums) {
        int min = Integer.MAX_VALUE, minIndex = -1;
        long sum = 0, rolling = 0;

        for (int x: nums) {
            sum += x;
        }

        for (int i = 0; i < nums.length; i++) {
            rolling += nums[i];
            long firstHalfAvg = rolling/(i + 1);
            long secondHalfAvg = i == nums.length - 1 ? 0 : (sum - rolling)/(nums.length - 1 - i);
            long diff = Math.abs(firstHalfAvg - secondHalfAvg);

            if (diff < min) {
                min = (int) diff;
                minIndex = i;
            }
        }

        return minIndex;
    }
}