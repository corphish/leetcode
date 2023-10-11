// https://leetcode.com/problems/median-of-two-sorted-arrays
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int target = (m + n)/2;
        
        if (m == 0 && n == 0) {
            return 0;
        }
        
        if (m == 0) {
            return n % 2 == 0 ? ((nums2[target] * 1.0) + nums2[target - 1])/2 : nums2[target];
        }
        
        if (n == 0) {
            return m % 2 == 0 ? ((nums1[target] * 1.0) + nums1[target - 1])/2 : nums1[target];
        }
        
        int[] arr = new int[m + n];
        int l = 0, r = 0, k = 0;
        while (k <= target) {
            if (l == m) {
                arr[k] = nums2[r++];
            } else if (r == n) {
                arr[k] = nums1[l++];
            } else if (nums1[l] <= nums2[r]) {
                arr[k] = nums1[l++];
            } else {
                arr[k] = nums2[r++];
            }
            k++;
        }
        
        return (m + n) % 2 == 0 ? ((arr[target] * 1.0) + arr[target - 1])/2 : arr[target];
    }
}