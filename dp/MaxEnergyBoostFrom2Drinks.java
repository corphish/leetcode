// https://leetcode.com/problems/maximum-energy-boost-from-two-drinks/
class Solution {
    public long maxEnergyBoost(int[] A, int[] B) {
        int n = A.length;
        long s0 = 0, s1 = 0, t = 0;

        for (int i = n - 1; i >= 0; i--) {
            t = Math.max(A[i] + s0, s1);
            s1 = Math.max(B[i] + s1, s0);
            s0 = t;
        }

        return Math.max(s0, s1);
    }

    long max(
        int[] A, int[] B,
        int i, int sel
    ) {
        if (i >= A.length) {
            return 0;
        }

        long max = (sel == 0 ? A[i] : B[i]) + max(A, B, i + 1, sel);

        // Switch
        max = Math.max(max, max(A, B, i + 1, (sel + 1) % 2));

        return max;
    }
}