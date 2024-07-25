// https://leetcode.com/problems/chalkboard-xor-game
class Solution {
    public boolean xorGame(int[] nums) {
        int xor = 0;
        for (int x: nums) xor = xor ^ x;
        return xor == 0 || nums.length % 2 == 0;
    }
}