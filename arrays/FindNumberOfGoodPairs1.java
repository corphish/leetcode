// https://leetcode.com/problems/find-the-number-of-good-pairs-i/
class Solution {
    public int numberOfPairs(int[] nums1, int[] nums2, int k) {
        int res = 0;
        int[] freq = new int[51];

        for (int x: nums2) {
            freq[x] += 1;
        }

        for (int v: nums1) {
            for (int d = 1; d * d <= v; d++) {
                if (v % d == 0) {
                    res += d % k == 0 ? freq[d/k] : 0;
                    if (d != v/d) {
                        res += (v/d) % k == 0 ? freq[(v/d)/k] : 0;
                    }
                }
            }
        }

        return res;
    }
}