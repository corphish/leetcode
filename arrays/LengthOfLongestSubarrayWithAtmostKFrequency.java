// https://leetcode.com/problems/length-of-longest-subarray-with-at-most-k-frequency
class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        int l = 0, r = 0;
        int res = 0;

        while (r < nums.length) {
            int rFreq = freq.getOrDefault(nums[r], 0);
            if (rFreq == k) {
                while (rFreq == k) {
                    if (nums[l] == nums[r]) {
                        rFreq -= 1;
                    }
                    
                    freq.put(nums[l], freq.getOrDefault(nums[l], 0) - 1);
                    l += 1;
                }
            }

            freq.put(nums[r], freq.getOrDefault(nums[r], 0) + 1);
            r += 1;

            res = Math.max(res, r - l);
        }

        return res;
    }
}