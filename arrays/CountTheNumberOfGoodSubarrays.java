// https://leetcode.com/problems/count-the-number-of-good-subarrays/
class Solution {
    public long countGood(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        int pairs = 0;
        int l = 0, r = 0;
        long count = 0;

        while (l <= r) {
            if (pairs >= k) {
                count += nums.length - r + 1;
                int f = freq.getOrDefault(nums[l], 0);
                pairs -= Math.max(0, f - 1);
                freq.put(nums[l], f - 1);
                l += 1;
            } else if (r < nums.length) {
                int f = freq.getOrDefault(nums[r], 0) + 1;
                pairs += Math.max(0, f - 1);
                freq.put(nums[r], f);
                r += 1;
            } else {
                int f = freq.getOrDefault(nums[l], 0);
                pairs -= Math.max(0, f - 1);
                freq.put(nums[l], f - 1);
                l += 1;
            }

            if (l == nums.length)
                break;
        }

        return count;
    }
}