class Solution {
    // Begin from the end, and if it is possible to jump to end
    // set the value for the particular position as true, else check if there
    // is any such position within the range where the value is true. If yes
    // set the value to be true else false.
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