// https://leetcode.com/problems/minimum-operations-to-make-the-array-increasing
class Solution {
    // In each iteration, we check if the element is bigger than its previous one.
    // If not, we make it 1 bigger than its previous element and increase ops accordingly.
    public int minOperations(int[] nums) {
        int ops = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                ops += nums[i - 1] - nums[i] + 1;
                nums[i] = nums[i - 1] + 1;
            }
        }
        
        return ops;
    }
}