// https://leetcode.com/problems/number-of-arithmetic-triplets
class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        int count = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            int x1 = Arrays.binarySearch(nums, nums[i] + diff);
            int x2 = Arrays.binarySearch(nums, nums[i] + 2 * diff);
            
            if (x1 > i && x2 > i) count++;
        }
        
        return count;
    }
}