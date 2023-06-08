// https://leetcode.com/problems/reduction-operations-to-make-the-array-elements-equal
class Solution {
    public int reductionOperations(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = nums.length - 1, ops = 0; i >= 0; i--, ops++) {
            if (i < nums.length - 1 && nums[i] < nums[i + 1]) {
                count += ops;
            }
        }

        return count;
    }
}