// https://leetcode.com/problems/largest-positive-integer-that-exists-with-its-negative
class Solution {
    public int findMaxK(int[] nums) {
        int[] freq = new int[2001];

        for (int x: nums) {
            freq[x + 1000] += 1;
        }

        int res = -1;
        for (int x: nums) {
            if (freq[-1 * Math.abs(x) + 1000] > 0 && freq[Math.abs(x) + 1000] > 0) {
                res = Math.max(res, Math.abs(x));
            }
        }

        return res;
    }
}