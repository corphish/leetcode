// https://leetcode.com/problems/k-radius-subarray-averages/
class Solution {
    public int[] getAverages(int[] nums, int k) {
        long[] prefix = new long[nums.length];
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            prefix[i] = nums[i];
            if (i > 0) {
                prefix[i] += prefix[i - 1];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (i - k >= 0 && i + k < nums.length) {
                // Sum of nums[i - k to i - 1]
                long a = (i - 1 < 0 ? 0 : prefix[i - 1]) - (i - k == 0 ? 0 : prefix[i - k - 1]);

                // Sum of nums[i + 1 to i + k]
                long b = prefix[i + k] - prefix[i];

                res[i] = (int) ((nums[i] + a + b)/(2 * k + 1));
            } else {
                res[i] = -1;
            }
        }

        return res;
    }
}