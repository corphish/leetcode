// https://leetcode.com/problems/2-keys-keyboard/
class Solution {
    public int minSteps(int n) {
        if (n < 2) return 0;
        
        return build(n, 1, 1);
    }
    
    // We can do things:
    // 1. Paste the one that is already copied (1 operation)
    // 2. Copy the current and paste it. (2 operations)
    int build(int n, int curr, int copied) {
        //System.out.printf("%d, %d, %d\n", n, curr, copied);
        if (n == curr) {
            return 1;
        }
        
        if (curr > n) {
            return n;
        }
        
        int res = Math.min(1 + build(n, curr + copied, copied), 2 + build(n, 2 * curr, curr));
        
        return res;
    }
}