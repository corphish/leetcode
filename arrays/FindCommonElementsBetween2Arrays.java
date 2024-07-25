// https://leetcode.com/problems/find-common-elements-between-two-arrays
class Solution {
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        int a = 0, b = 0;

        for (int x: nums1) {
            for (int y: nums2) {
                if (x == y) {
                    a++;
                    break;
                }
            }
        }

        for (int x: nums2) {
            for (int y: nums1) {
                if (x == y) {
                    b++;
                    break;
                }
            }
        }

        return new int[] { a, b };
    }
}