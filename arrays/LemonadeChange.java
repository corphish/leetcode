// https://leetcode.com/problems/lemonade-change
class Solution {
    public boolean lemonadeChange(int[] bills) {
        int[] reg = new int[3];
        for (int x: bills) {
            reg[x/10]++;
            
            if (x > 5) {
                int diff = x - 5;
                if (!makeChange(reg, diff)) return false;
            }
        }
        
        return true;
    }
    
    boolean makeChange(int[] reg, int change) {
        if (change == 0) return true;
        
        for (int i = 1; i >= 0; i--) {
            int bill = 5 * (i + 1);
            if (bill <= change && reg[i] > 0) {
                reg[i]--;
                return makeChange(reg, change - bill);
            }
        }
        
        return false;
    }
}