// https://leetcode.com/problems/increasing-triplet-subsequence
class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        
        int left = Integer.MAX_VALUE, middle = Integer.MAX_VALUE;
        
        // x is right, we already have left and midd;e
        for (int x: nums) {
            // If x is less than left, we start over
            // we assign left to x
            if (x <= left) {
                left = x;
            } else if (x <= middle) {
                // If x is greater than left but less than middle
                // we have 2nd element in triplet, so we set middle to x.
                middle = x;
            } else {
                // At this point we have x > left and x > middle
                // So we can form a pair left < middle < x
                return true;
            }
        }
        
        // Will only reach here if first 2 conditions in loop keep on getting
        // satisfied
        return false;
    }
}