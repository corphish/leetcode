// https://leetcode.com/problems/maximum-number-of-pairs-in-array
class Solution {
    public int[] numberOfPairs(int[] nums) {
        int[] freq = new int[101];

        for (int x: nums) {
            freq[x]++;
        }

        int p = 0, r = 0;
        for (int x: freq) {
            p += x/2;
            r += x % 2;
        }

        return new int[] {p, r};
    }
}