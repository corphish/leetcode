// https://leetcode.com/problems/sum-of-all-subset-xor-totals
class Solution {
    int sum;
    public int subsetXORSum(int[] nums) {
        xor(nums, 0, 0);
        return sum;
    }

    void xor(int[] nums, int i, int roll) {
        if (i == nums.length) {
            sum += roll;
            return;
        }

        xor(nums, i + 1, roll);
        xor(nums, i + 1, roll ^ nums[i]);
    }
}