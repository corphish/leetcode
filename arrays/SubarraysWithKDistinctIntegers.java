// https://leetcode.com/problems/subarrays-with-k-different-integers
class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int max = 0;
        for (int x: nums) max = Math.max(max, x);

        return func(nums, k, max) - func(nums, k - 1, max);
    }

    int func(int[] nums, int k, int max) {
        int[] freq = new int[max + 1];
        int l = 0, r = 0;
        int count = 0, unique = 0;

        while (r < nums.length) {
            if (r == nums.length) {
                freq[nums[l]] -= 1;
                if (freq[nums[l]] == 0) {
                    unique -= 1;
                }

                l += 1;
            } else {
                freq[nums[r]] += 1;
                if (freq[nums[r]] == 1) {
                    unique += 1;
                }

                while (unique > k) {
                    freq[nums[l]] -= 1;
                    if (freq[nums[l]] == 0) {
                        unique -= 1;
                    }

                    l += 1;
                }

                r += 1;
            }

            count += r - l;
        }

        return count;
    }
}