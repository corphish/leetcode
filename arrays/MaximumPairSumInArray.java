// https://leetcode.com/problems/max-pair-sum-in-an-array/
class Solution {
    public int maxSum(int[] nums) {
        int max = -1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (check(nums[i]) > 0 && check(nums[i]) == check(nums[j])) {
                    max = Math.max(max, nums[i] + nums[j]);
                }
            }
        }

        return max;
    }

    int check(int n) {
        int r = -1;
        while (n > 0) {
            int x = n % 10;
            if (r == -1) {
                r = x;
            } else if (r != x) {
                r = Math.max(r, x);
            }

            n /= 10;
        }

        return r;
    }
}