// https://leetcode.com/problems/jump-game/
class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] jumpState = new boolean[n];
        jumpState[n - 1] = true;
        
        for (int i = n - 2; i >= 0; i--) {
            if (i + nums[i] >= n - 1) {
                jumpState[i] = true;
            } else {
                boolean positionFound = false;
                for (int j = i; j <= i + nums[i]; j++) {
                    if (jumpState[j]) {
                        positionFound = true;
                        break;
                    }
                }
                
                jumpState[i] = positionFound;
            }
        }
        
        return jumpState[0];
    }
}