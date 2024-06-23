// https://leetcode.com/problems/special-array-with-x-elements-greater-than-or-equal-x
class Solution {
    public int specialArray(int[] nums) {
        for (int i = 0; i <= nums.length; i++) {
            int count = 0;
            for (int x: nums) {
                if (x >= i) count++;
            }
            
            if (i == count) return i;
        }
        
        return -1;
    }
}