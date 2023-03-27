// https://leetcode.com/problems/number-of-zero-filled-subarrays/
class Solution {
    public long zeroFilledSubarray(int[] nums) {
        int last = -1, i = 0;
        long count = 0, x;
        for (; i < nums.length; i++) {
            if (nums[i] != 0) {
                x = i - last - 1;
                count += (x * (x + 1)/2);
                last = i;
            }
        }

        x = i - last - 1;
        count += (x * (x + 1)/2);

        return count;
    }
}