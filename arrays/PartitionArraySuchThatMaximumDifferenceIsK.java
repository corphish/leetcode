// https://leetcode.com/problems/partition-array-such-that-maximum-difference-is-k/description/
class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 1, last = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[last] > k) {
                count += 1;
                last = i;
            }
        }

        return count;
    }
}