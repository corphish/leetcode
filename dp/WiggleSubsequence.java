// https://leetcode.com/problems/wiggle-subsequence
class Solution {
    public int wiggleMaxLength(int[] nums) {
        int inc = 1, dec = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                inc = dec + 1;
            } else if (nums[i] < nums[i - 1]) {
                dec = inc + 1;
            }
        }

        return Math.max(inc, dec);
    }

    // type - 0 = we are looking number greater num[i], 1 = less
    int max(int[] nums, int i, int type) {
        if (i == nums.length) {
            return 0;
        }

        int max = 1;
        for (int j = i + 1; j < nums.length; j++) {
            if ((type == 0 && nums[j] > nums[i]) || (type == 1 && nums[j] < nums[i])) {
                max = Math.max(max, 1 + max(nums, j, (type + 1) % 2));
            }
        }

        return max;
    }
}