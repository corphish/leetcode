// https://leetcode.com/problems/count-number-of-bad-pairs/
class Solution {
    public long countBadPairs(int[] nums) {
        long count = 0;
        Map<Integer, Integer> freq = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int x = nums[i] - i;
            int f = freq.getOrDefault(x, 0);
            count += i - f;
            freq.put(x, f + 1);
        }

        return count;
    }
}