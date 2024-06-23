// https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit
class Solution {
    public int longestSubarray(int[] nums, int limit) {
        TreeMap<Integer, Integer> min = new TreeMap<>();
        TreeMap<Integer, Integer> max = new TreeMap<>(Collections.reverseOrder());
        
        // Inclusive
        int l = 0, r = 0, res = 1;

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                min.put(nums[i], 1);
                max.put(nums[i], 1);
            } else {
                min.put(nums[i], min.getOrDefault(nums[i], 0) + 1);
                max.put(nums[i], max.getOrDefault(nums[i], 0) + 1);

                r += 1;
            }

            if (max.firstKey() - min.firstKey() > limit) {
                int x = nums[l];

                min.put(x, min.get(x) - 1);
                max.put(x, max.get(x) - 1);

                if (min.get(x) == 0) {
                    min.remove(x);
                }

                if (max.get(x) == 0) {
                    max.remove(x);
                }

                l += 1;
            }

            res = Math.max(res, r - l + 1);
        }

        return res;
    }
}