// https://leetcode.com/problems/maximum-ascending-subarray-sum
class Solution {
    public int maxAscendingSum(int[] nums) {
        int max = 0;
        int last = -1, sum = 0;

        for (int x: nums) {
            if (x > last) {
                sum += x;
            } else {
                max = Math.max(max, sum);
                sum = x;
            }

            last = x;
        }

        return Math.max(max, sum);
    }
}