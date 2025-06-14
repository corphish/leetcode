// https://leetcode.com/problems/find-the-largest-almost-missing-integer/
class Solution {
    public int largestInteger(int[] nums, int k) {
        int max = -1;
        boolean l = false, r = false;
        int[] freq = new int[51];

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[0]) {
                l = true;
            }

            if (i < nums.length - 1 && nums[i] == nums[nums.length - 1]) {
                r = true;
            }

            max = Math.max(max, nums[i]);
            freq[nums[i]] += 1;
        }

        if (k == nums.length) {
            return max;
        }

        if (k == 1) {
            int res = -1;
            for (int i = 0; i < 51; i++) {
                if (freq[i] == 1) {
                    res = i;
                }
            }

            return res;
        }

        if (l && r) return -1;
        if (l) return nums[nums.length - 1];
        if (r) return nums[0];

        return Math.max(nums[0], nums[nums.length - 1]); 
    }
}