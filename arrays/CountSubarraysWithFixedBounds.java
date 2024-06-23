// https://leetcode.com/problems/count-subarrays-with-fixed-bounds
class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long count = 0;
        int l = -1, r = -1, bound = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < minK || nums[i] > maxK) {
                bound = i;
            } 
            
            if (nums[i] == minK) {
                l = i;
            } 
            
            if (nums[i] == maxK) {
                r = i;
            }

            count += Math.max(0, Math.min(l, r) - bound);
        }

        return count;
    }
}