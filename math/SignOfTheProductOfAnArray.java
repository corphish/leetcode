// https://leetcode.com/problems/sign-of-the-product-of-an-array
class Solution {
    public int arraySign(int[] nums) {
        int p = 1;
        for (int x: nums) {
            if (x == 0) return 0;
            p *= x < 0 ? -1 : 1;
        }
        
        return p;
    }
}