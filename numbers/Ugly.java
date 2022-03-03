// https://leetcode.com/problems/ugly-number
class Solution {
    public boolean isUgly(int n) {
        //System.out.println(n);
        if (n == 0) return false;
        if (n == 1) return true;
        for (int i = 2; i < 7; i++) {
            if (i > 5) return false;
            if (n % i == 0) return isUgly(n/i);
        }
        
        return true;
    }
}