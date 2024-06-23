// https://leetcode.com/problems/count-subarrays-where-max-element-appears-at-least-k-times
class Solution {
    public long countSubarrays(int[] nums, int k) {
        int max = 0;
        for (int x: nums) max = Math.max(max, x);

        int freq = 0, l = 0, r = 0;
        long count = 0;

        while (l < nums.length) {
            if (freq == k) {
                count += nums.length - r + 1;
                if (nums[l] == max) {
                    freq -= 1;
                }

                l += 1;
            } else {
                if (r == nums.length) {
                    break;
                }

                if (r < nums.length && nums[r] != max) {
                    r += 1;
                    continue;
                }

                freq += 1;
                r += 1;
            }  
        }

        return count;
    }
}