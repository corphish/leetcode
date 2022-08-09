// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
class Solution {
    public int[] searchRange(int[] nums, int target) {
        return new int[] {
            binarySearch(nums, target, 0),
            binarySearch(nums, target, 1),
        };
    }
    
    // 0 - left
    // 1 - right
    int binarySearch(int[] nums, int target, int direction) {
        int low = 0, high = nums.length - 1;
        
        while (low <= high) {
            int mid = (low + high)/2;
            if (nums[mid] == target) {
                if (direction == 0) {
                    if (mid == 0) {
                        return mid;
                    }
                    
                    if (nums[mid - 1] != target) {
                        return mid;
                    }
                    
                    high = mid - 1;
                } else if (direction == 1) {
                    if (mid == nums.length - 1) {
                        return mid;
                    }
                    
                    if (nums[mid + 1] != target) {
                        return mid;
                    }
                    
                    low = mid + 1;
                } else {
                    return mid;
                }
            } else {
                if (nums[mid] > target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        
        return -1;
    }
}