// https://leetcode.com/problems/minimum-deletions-to-make-array-divisible/
class Solution {
    public int minOperations(int[] nums, int[] numsDivide) {
        int target = numsDivide.length == 1 ? numsDivide[0] : gcd(numsDivide[0], numsDivide[1]);
        for (int i = 2; i < numsDivide.length; i++) {
            target = gcd(target, numsDivide[i]);
        }
        
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (target % nums[i] == 0) {
                return i;
            }    
        }
        
        return -1;
    }
    
    int gcd(int x, int y) {
        return x % y == 0 ? y : gcd(y, x % y);
    }
}