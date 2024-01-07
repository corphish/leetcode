// https://leetcode.com/problems/arithmetic-slices-ii-subsequence
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        Map<Integer, Map<Long, Integer>> memo = new HashMap<>();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                long diff = 0L + nums[j] - nums[i];
                count += count(nums, j, diff, memo);
            }
        }

        return count;
    }

    int count(int[] nums, int i, long diff, Map<Integer, Map<Long, Integer>> memo) {
        if (i >= nums.length) {
            return 0;
        }

        if (memo.containsKey(i)) {
            Map<Long, Integer> seg = memo.get(i);
            if (seg.containsKey(diff)) {
                return seg.get(diff);
            }
        }

        int count = 0;
        for (int j = i + 1; j < nums.length; j++) {
            if (0L + nums[j] - nums[i] == diff) {
                count += 1 + count(nums, j, diff, memo);
            }
        }

        memo.computeIfAbsent(i, x -> new HashMap<>()).put(diff, count);

        return count;
    }
}