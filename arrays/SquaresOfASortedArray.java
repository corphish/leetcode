// https://leetcode.com/problems/squares-of-a-sorted-array
class Solution {
    public int[] sortedSquares(int[] nums) {
        int minIndex = 0;
        int[] res = new int[nums.length];
        int k = 0;
        
        for (; minIndex < nums.length && nums[minIndex] < 0; minIndex++);
        int l = minIndex - 1, r = minIndex;
        
        for(; k < nums.length; k++) {
            if (l >= 0 && (r > nums.length - 1 || Math.abs(nums[l]) < Math.abs(nums[r]))) {
                res[k] = nums[l] * nums[l];
                l--;
            } else {
                res[k] = nums[r] * nums[r];
                r++;
            }
        }
        
        return res;
    }
}