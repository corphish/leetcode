// https://leetcode.com/problems/non-decreasing-array
class Solution {
    public boolean checkPossibility(int[] nums) {
        return strategy1(nums.clone()) || strategy2(nums);
    }
    
    // Strategy 1:
    // If nums[i] > nums[i + 1]
    // We make nums[i] = nums[i - 1] if i > 0 else nums[i + 1]
    // In this strategy, after a change, we must consider that index again
    // in order to check if the current modification is valid or not.
    boolean strategy1(int[] nums) {
        boolean isSwapped = false;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                if (isSwapped) {
                    return false;
                }
                
                if (i == 0) {
                    nums[i] = nums[i + 1];
                } else {
                    int x = nums[i - 1];
                    /*if (x > nums[i + 1]) {
                        return false;
                    }*/
                    
                    nums[i] = x;
                    i--;
                }
                
                isSwapped = true;
            }
        }
        
        return true;
    }
    
    // Strategy 1:
    // If nums[i] > nums[i + 1]
    // We make nums[i + 1] = nums[i] if i > 0 else nums[i] = nums[i + 1]
    boolean strategy2(int[] nums) {
        boolean isSwapped = false;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                if (isSwapped) {
                    return false;
                }
                
                if (i == 0) {
                    nums[i] = nums[i + 1];
                } else {
                    nums[i + 1] = nums[i];
                }
                
                isSwapped = true;
            }
        }
        
        return true;
    }
}