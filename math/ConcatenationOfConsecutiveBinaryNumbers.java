// https://leetcode.com/problems/concatenation-of-consecutive-binary-numbers/
class Solution {
    public int concatenatedBinary(int n) {
        int res = 0;
        for (int i = 1; i <= n; i++) {
            String s = Integer.toBinaryString(i);
            for (char c: s.toCharArray()) {
                int val = c - '0';
                res = res * 2 + val;
                res %= 1000000007;
            }
        }
        
        return res;
    }
}