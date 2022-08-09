class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        // [2, 5, 6, 8, 12, 15]
        return slidingWindow(target, nums);
    }
    
    // Prefix sum binary search approach
    // We have to discard indexes found by binary search that are greater than array bounds.
    // Logic is to build the prefix sum array, and check where the potential target could be in the prefix sum array.
    // Works only when all elements in nums are positive.
    // 5ms
    int prefixSum(int target, int[] nums) {
        int[] prefix = nums.clone();
        
        for (int i = 1; i < nums.length; i++) {
            prefix[i] += prefix[i - 1];
        }
        
        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i < nums.length; i++) {
            int ix;
            if (i == 0) {
                ix = Arrays.binarySearch(prefix, target);
            } else {
                ix = Arrays.binarySearch(prefix, target + prefix[i - 1]);
            }
            
            if (ix < 0) ix = -ix - 1;
            
            if (ix >= nums.length) continue;
            
            min = Math.min(min, ix - i + 1);
        }
        
        return min == Integer.MAX_VALUE ? 0 : min;
    }
    
    // Sliding window approach
    // l and r are both inclusive
    // count = r - l + 1
    int slidingWindow(int target, int[] nums) {
        int l = 0, r = 0, min = Integer.MAX_VALUE;
        int rollingSum = nums[0];
        
        for (; l < nums.length;) {
            if (rollingSum < target) {
                if (r < nums.length - 1)  {
                    r += 1;
                    rollingSum += nums[r];
                } else {
                    rollingSum -= nums[l];
                    l += 1;
                }
            } else {
                min = Math.min(min, r - l + 1);
                rollingSum -= nums[l];
                l += 1;
            }
        }
        
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}