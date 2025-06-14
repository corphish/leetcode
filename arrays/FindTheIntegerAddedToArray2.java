// https://leetcode.com/problems/find-the-integer-added-to-array-ii/
class Solution {
    public int minimumAddedInteger(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int min = Integer.MAX_VALUE;

        for (int i1 = 0; i1 < nums1.length; i1++) {
            for (int i2 = i1 + 1; i2 < nums1.length; i2++) {
                int[] res = verify(nums1, nums2, i1, i2);
                if (res[0] == 1) {
                    min = Math.min(min, res[1]);
                }
            }
        }

        return min;
    }

    int[] verify(int[] a1, int[] a2, int x1, int x2) {
        int diff = Integer.MAX_VALUE;
        int i1 = 0, i2 = 0;

        while (i2 < a2.length) {
            if (i1 == x1 || i1 == x2) {
                i1 += 1;
                continue;
            }

            if (diff == Integer.MAX_VALUE) {
                diff = a2[i2] - a1[i1];
            } else {
                if (a2[i2] - a1[i1] != diff) {
                    return new int[] { 0, 0 };
                }
            }

            i1 += 1;
            i2 += 1;
        }

        return new int[] { 1, diff };
    }
}