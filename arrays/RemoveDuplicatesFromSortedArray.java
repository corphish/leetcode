// https://leetcode.com/problems/remove-duplicates-from-sorted-array
class Solution {
    public int removeDuplicates(int[] nums) {
        int p = 1, l = nums.length > 0 ? nums[0] : 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != l) {
                nums[p++] = nums[i];
                l = nums[i];
            }
        }
        
        return p;
    }
}