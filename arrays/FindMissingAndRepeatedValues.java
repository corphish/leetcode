// https://leetcode.com/problems/find-missing-and-repeated-values/
class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int[] freq = new int[n * n + 1];
        int[] res = new int[2];

        for (int[] arr : grid) {
            for (int x : arr) {
                if (freq[x] == 1) {
                    res[0] = x;
                } else {
                    freq[x] = 1;
                }
            }
        }

        for (int i = 1; i < freq.length; i++) {
            if (freq[i] == 0) {
                res[1] = i;
                break;
            }
        }

        return res;
    }
}