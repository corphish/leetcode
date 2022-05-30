// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array
class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;
        
        if (nums.length == 1) {
            return nums[0];
        }
        
        while (l <= r) {
            int mid = (l + r)/2;
            if (mid == 0)
                return Math.min(nums[0], nums[1]);
            if (nums[mid] < nums[mid - 1]) return nums[mid];
            if (nums[mid] < nums[n - 1]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        
        return nums[0];
    }
}