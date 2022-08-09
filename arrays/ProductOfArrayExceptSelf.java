// https://leetcode.com/problems/product-of-array-except-self
class Solution {
    // Input = [1, 2, 3, 4]
    // We make prefix array = [1, 1, 2, 6]
    // We make suffix array = [24, 12, 4, 1]
    // res[i] = prefix[i] * suffix[i]
    public int[] productExceptSelf(int[] nums) {
        int[] res = nums.clone();
        res[0] = 1;
        
        for (int i = 1; i < nums.length; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        
        // [24,12,4,1]
        int k = nums[nums.length - 1];
        nums[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            int t = nums[i];
            nums[i] = k * nums[i + 1];
            k = t;
        }
        
        for (int i = 0; i < nums.length; i++) {
            res[i] *= nums[i];
        }
        
        return res;
    }
}