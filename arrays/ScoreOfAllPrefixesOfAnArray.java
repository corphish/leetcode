// https://leetcode.com/problems/find-the-score-of-all-prefixes-of-an-array/
class Solution {
    public long[] findPrefixScore(int[] nums) {
        long[] res = new long[nums.length];
        int max = nums[0];

        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            if (i == 0) {
                res[i] = max + nums[i];
            } else {
                res[i] = res[i - 1] + max + nums[i];
            }
        }

        return res;
    }
}