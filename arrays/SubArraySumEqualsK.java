// https://leetcode.com/problems/subarray-sum-equals-k
class Solution {
    public int subarraySum(int[] nums, int k) {
        int[] prefix = nums.clone();
        for (int i = 1; i < nums.length; i++) {
            prefix[i] += prefix[i - 1];
        }

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == k) {
                count += 1;
            }
            for (int j = i + 1; j < nums.length; j++) {
                int sum = prefix[j] - (i == 0 ? 0 : prefix[i - 1]);
                if (sum == k) {
                    count += 1;
                }
            }
        }

        return count;
    }
}