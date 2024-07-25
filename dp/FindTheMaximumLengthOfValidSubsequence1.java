// https://leetcode.com/problems/find-the-maximum-length-of-valid-subsequence-i/
class Solution {
    public int maximumLength(int[] nums) {
        int[] memo = new int[nums.length * 8];
        Arrays.fill(memo, -1);

        return Math.max(
            max(nums, 0, 2, 0, memo),
            max(nums, 0, 2, 1, memo)
        );
    }

    int max(int[] nums, int i, int last, int par, int[] memo) {
        if (i == nums.length) {
            return 0;
        }

        int key = (i << 3) + (last * 2) + par;

        if (memo[key] != -1) {
            return memo[key];
        } 

        int max = max(nums, i + 1, last, par, memo);

        if (last == 2 || (last + nums[i]) % 2 == par) {
            max = Math.max(max, 1 + max(nums, i + 1, nums[i] % 2, par, memo));
        }

        return memo[key] = max;
    }
}