// https://leetcode.com/problems/smallest-string-with-a-given-numeric-value/
class Solution {
    public String getSmallestString(int n, int k) {
        int[] res = new int[n];
        int ix = n - 1;
        
        while (n > 0) {
            int c = 26 - Math.max(0, n - k + 25);
            res[ix--] = 96 + c;
            
            n -= 1;
            k -= c;
        }
        
        return new String(res, 0, res.length);
    }
}