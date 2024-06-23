// https://leetcode.com/problems/count-number-of-nice-subarrays
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] & 1;
        }

        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }

        int[] freq = new int[nums.length + 1];
        int count = 0, max = 0;
        freq[0] = 1;
        for (int x: nums) {
            freq[x] += 1;
            max = Math.max(max, x);
        }

        for (int i = k; i <= max; i++) {
            count += freq[i] * freq[i - k];
        }

        return count;
    }
}