// https://leetcode.com/problems/minimum-common-value
class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int l = 0, r = 0;
        while (true) {
            if (nums1[l] == nums2[r]) {
                return nums1[l];
            }

            while (l < nums1.length && nums1[l] < nums2[r]) {
                l += 1;
            }
            
            if (l >= nums1.length) break;

            while (r < nums2.length && nums2[r] < nums1[l]) {
                r += 1;
            }

            if (r >= nums2.length) break;
        }

        return -1;
    }
}