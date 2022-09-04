// https://leetcode.com/problems/power-of-three/
class Solution {
    public boolean isPowerOfThree(int n) {
        int x = 1;
        for (; x != n && x > 0; x *= 3);
        
        return x > 0;
    }
}