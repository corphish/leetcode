// https://leetcode.com/problems/find-peak-element
class Solution {
    // Logic: Perform binary search
    // If nums[mid] > nums[mid - 1] and nums[mid] > nums[mid + 1], return mid
    // else search in non-sorted part of the array.
    // Make sure to handle edges.
    public int findPeakElement(int[] nums) {
        return search(nums, 0, nums.length - 1);
    }
    
    int search(int[] nums, int l, int r) {
        if (l > r) return -1;
        
        int mid = (l + r)/2;
        boolean hasL = mid > 0;
        boolean hasR = mid < nums.length - 1;
        int lv = mid == 0 ? Integer.MIN_VALUE : nums[mid - 1];
        int rv = mid == nums.length - 1 ? Integer.MIN_VALUE : nums[mid + 1];
        
        if (hasL && hasR) {
            if (nums[mid] > lv && nums[mid] > rv) {
                return mid;
            }
        } else if (hasL) {
            if (nums[mid] > lv) {
                return mid;
            }
        } else if (hasR) {
            if (nums[mid] > rv) {
                return mid;
            }
        } else {
            return mid;
        } 
        
        if (lv > nums[mid]) {
            return search(nums, l, mid - 1);
        }
        
        else {
            return search(nums, mid + 1, nums.length - 1);
        }
    }
}