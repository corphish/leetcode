// https://leetcode.com/problems/minimum-numbers-of-function-calls-to-make-target-array
class Solution {
    public int minOperations(int[] nums) {
        int moves = 0;
        
        while (true) {
            boolean allZeroes = true;
            int tempMoves = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    allZeroes = false;
                }
                
                if (nums[i] % 2 == 1) {
                    nums[i]--;
                    tempMoves++;
                }
            }
            
            if (allZeroes) {
                break;
            }
            
            allZeroes = true;
            
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    allZeroes = false;
                }
                
                nums[i] /= 2;
            }
            
            tempMoves += !allZeroes ? 1 : 0;
            moves += tempMoves;
        }
        
        return moves;
    }
}