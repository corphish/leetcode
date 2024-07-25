// https://leetcode.com/problems/maximum-xor-for-each-query/
class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int[] res = new int[nums.length];
        int xor = 0;

        for (int i = 0; i < res.length; i++) {
            xor = xor ^ nums[i];
            res[nums.length - 1 - i] = xor ^ ((1 << maximumBit) - 1);
        }

        return res;
    }
}