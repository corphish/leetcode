// https://leetcode.com/problems/largest-combination-with-bitwise-and-greater-than-zero/
class Solution {
    public int largestCombination(int[] candidates) {
        int[] freq = new int[32];
        int max = 0;
        for (int x: candidates) {
            int k = 0;
            while (x > 0) {
                freq[k] += x & 1;
                x >>= 1;
                max = Math.max(max, freq[k]);
                k++;
            }
        }

        return max;
    }
}