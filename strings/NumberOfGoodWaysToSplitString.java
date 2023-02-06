// https://leetcode.com/problems/number-of-good-ways-to-split-a-string/
class Solution {
    public int numSplits(String s) {
        int[] leftFreq = new int[32], rightFreq = new int[32];
        int leftVal = 0, rightVal = 0, count = 0;

        for (char c: s.toCharArray()) {
            int index = c - 'a';
            rightFreq[index]++;

            if (rightFreq[index] == 1) {
                rightVal |= 1 << index;
            }
        }

        for (char c: s.toCharArray()) {
            int index = c - 'a';

            rightFreq[index]--;
            leftFreq[index]++;

            if (leftFreq[index] == 1) {
                leftVal |= 1 << index;
            }

            if (rightFreq[index] == 0) {
                // (n & ~(1 << (k - 1)))
                rightVal &= ~(1 << index);
            }

            if (Integer.bitCount(leftVal) == Integer.bitCount(rightVal)) {
                count++;
            }
        }

        return count;
    }
}