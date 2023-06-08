// https://leetcode.com/problems/maximum-sum-with-exactly-k-elements
class Solution {
    public int maximizeSum(int[] nums, int k) {
        int max = 0;
        for (int x: nums) max = Math.max(max, x);
        return k * (2 * max + (k - 1))/2;
    }
}