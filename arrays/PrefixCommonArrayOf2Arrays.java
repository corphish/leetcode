// https://leetcode.com/problems/find-the-prefix-common-array-of-two-arrays
class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] freq1 = new int[n + 1], freq2 = new int[n + 1], res = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                freq1[A[j]]++;
                freq2[B[j]]++;
            }

            for (int j = 0; j <= n; j++) {
                res[i] += Math.min(freq1[j], freq2[j]);
            }

            Arrays.fill(freq1, 0);
            Arrays.fill(freq2, 0);
        }

        return res;
    }
}