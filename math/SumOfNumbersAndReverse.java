// https://leetcode.com/problems/sum-of-number-and-its-reverse
class Solution {
    public boolean sumOfNumberAndReverse(int num) {
        for (int i = 0; i <= num; i++) {
            if (i + rev(i) == num) {
                return true;
            }
        }
        
        return false;
    }
    
    int rev(int n) {
        int r = 0;
        while (n > 0) {
            r = r * 10 + (n % 10);
            n /= 10;
        }
        
        return r;
    }
}