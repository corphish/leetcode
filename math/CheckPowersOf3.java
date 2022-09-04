// https://leetcode.com/problems/check-if-number-is-a-sum-of-powers-of-three/
class Solution {
    public boolean checkPowersOfThree(int n) {
        String base3 = Integer.toString(n, 3);
        
        return !base3.contains("2");
    }
}