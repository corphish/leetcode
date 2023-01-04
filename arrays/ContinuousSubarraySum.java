// https://leetcode.com/problems/continuous-subarray-sum
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        boolean hasContinuousZero = false;
        for (int i = 1; i < nums.length; i++) {
            // Prefix sum
            nums[i] += nums[i - 1];
            
            // To check for consecutive zeroes in a prefix sum
            // For i = 1, it is self explanatory
            // For i > 1, let arr = [33, 0, 0], prefix = [33, 33, 33]
            // So in running prefix sum, in order to detect 2 consectutive zeroes
            // we check nums[i] and nums[i - 2] if they are equal or not
            if ((i == 1 && nums[i] == 0 && nums[i - 1] == 0) || (i > 1 && nums[i] == nums[i - 2])) {
                hasContinuousZero = true;
            }
        }
        
        // If we have continuous zeroes, we have a subarray
        // 0 is multiple of k
        if (hasContinuousZero) {
            return true;
        }
        
        if (nums.length < 2) {
            return false;
        }
        
        if (nums[1] % k == 0) {
            return true;
        }
        
        if (nums[nums.length - 1] % k == 0) {
            return true;
        }
        
        if (k > nums[nums.length - 1]) {
            return hasContinuousZero;
        }
        
        NumTracker tracker = new NumTracker(k);
        for (int i = 2; i < nums.length; i++) {
            // Track i - 2 element so that the sub array we can form is of size atleast 2
            tracker.add(nums[i - 2]);
            
            // If prefix sum is divisible by k, we have a solution
            if (nums[i] % k == 0) {
                return true;
            }
            
            // If we have a target mod value which we have already tracked,
            // we have a solution.
            if (tracker.hasAny(nums[i])) {
                return true;
            }
        }
        
        return false;
    }
    
    class NumTracker {
        int k;
        Map<Integer, Boolean> modMap = new HashMap<>();
        
        NumTracker(int k) {
            this.k = k;
        }
        
        void add(int n) {
            modMap.put(n % k, true);
        }
        
        boolean hasAny(int n) {
            int target = n % k;
            return modMap.getOrDefault(target, false);
        }
    }
}