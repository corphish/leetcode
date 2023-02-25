// https://leetcode.com/problems/search-insert-position/
class Solution {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int l = 0, r = n - 1, m = (l + r)/2;
        
        while (l <= r) {
            if (nums[m] == target) {
                return m;
            }
            
            if (nums[m] < target) {
                l = m + 1;
            }
            
            if (nums[m] > target) {
                r = m - 1;
            }
            
            m = (l + r)/2;
        }
        
        return l;
    }
}