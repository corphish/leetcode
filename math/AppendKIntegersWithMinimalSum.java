// https://leetcode.com/problems/append-k-integers-with-minimal-sum
class Solution {
    public long minimalKSum(int[] nums, int k) {
        long sum = 0;
        Arrays.sort(nums);
        
        // First fill with min possible values starting from 1 if the min element
        // of array is not 1
        if (k > 0) {
            if (nums[0] != 1) {
                sum += nSum(Math.min(k, nums[0] - 1));
                k -= Math.min(k, nums[0] - 1);
            }
        }
        
        // This loop will feel any non-contiguos parts within the array
        for (int i = 1; i < nums.length && k > 0; i++) {
            if (nums[i] - nums[i - 1] > 1) {
                int missingCount = nums[i] - nums[i - 1] - 1;
                if (missingCount <= k) {
                    sum += nSum(nums[i] - 1) - nSum(nums[i - 1]);
                    k -= missingCount;
                } else {
                    sum += nSum(nums[i - 1] + k) - nSum(nums[i - 1]);
                    k = 0;
                }
            }
        }
        
        // If still we have spare left, fill the remaining with larger ints greater the largest one
        // in array.
        if (k > 0) {
            sum += nSum(nums[nums.length - 1] + k) - nSum(nums[nums.length - 1]);
        }
        
        return sum;
    }
    
    // Sum of 1..n
    long nSum(int n) {
        return 1L * n * (n + 1)/2;
    }
}