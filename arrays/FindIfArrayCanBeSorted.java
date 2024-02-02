// https://leetcode.com/problems/find-if-array-can-be-sorted/
class Solution {
    public boolean canSortArray(int[] nums) {
        int currSegMin = Integer.MAX_VALUE;
        int currSegMax = 0;
        int currSegBit = -1;

        int[][] segment = new int[nums.length][2];
        int k = 0;

        for (int x: nums) {
            int bit = Integer.bitCount(x);
            if (currSegBit == -1) {
                currSegBit = bit;
                currSegMin = x;
                currSegMax = x;
            } else if (currSegBit == bit) {
                currSegMin = Math.min(x, currSegMin);
                currSegMax = Math.max(x, currSegMax);
            } else {
                segment[k][0] = currSegMin;
                segment[k][1] = currSegMax;
                k += 1;
                currSegBit = bit;
                currSegMin = x;
                currSegMax = x;
            }
        }

        segment[k][0] = currSegMin;
        segment[k][1] = currSegMax;
        k += 1;

        for (int i = 1; i < k; i++) {
            if (segment[i][0] < segment[i - 1][1]) {
                return false;
            }
        }

        return true;
    }
}