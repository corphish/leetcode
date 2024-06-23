// https://leetcode.com/problems/find-the-number-of-good-pairs-ii/
class Solution {
    public long numberOfPairs(int[] nums1, int[] nums2, int k) {
        long res = 0;
        Arrays.sort(nums2);
        Arrays.sort(nums1);

        int[] freq = new int[Math.max(nums1[nums1.length - 1], nums2[nums2.length - 1]) + 1];

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