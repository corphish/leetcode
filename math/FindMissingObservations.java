// https://leetcode.com/problems/find-missing-observations
class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int sum = mean * (m + n);
        
        for (int x: rolls) {
            sum -= x;
        }
        
        if (6 * n < sum) {
            return new int[] {};
        }
        
        int[] res = new int[n];
        int base = sum/n;
        
        if (base <= 0) {
            return new int[] {};
        }
        
        for (int i = 0; i < n; i++) {
            res[i] = base;
            sum -= base;
        }
        
        while (sum > 0) {
            for (int i = 0; i < n; i++) {
                res[i]++;
                sum--;
                
                if (sum == 0) break;
            }
        }
        
        return res;
    }
}