// https://leetcode.com/problems/next-greater-element-iii
// Algorithm from - https://www.geeksforgeeks.org/find-next-greater-number-set-digits/
class Solution {
    public int nextGreaterElement(int n) {
        int breakPoint = -1;
        char[] num = ("" + n).toCharArray();
        
        for (int i = num.length - 2; i >= 0; i--) {
            if (num[i] < num[i + 1]) {
                breakPoint = i;
                break;
            }
        }
        
        if (breakPoint < 0) {
            return -1;
        }
        
        char nextMin = 'a';
        int ix = breakPoint;
        
        for (int i = ix + 1; i < num.length; i++) {
            if (num[i] > num[breakPoint]) {
                if (nextMin == 'a' || num[i] < nextMin) {
                    nextMin = num[i];
                    ix = i;
                }   
            }
        }
        
        char temp = num[ix];
        num[ix] = num[breakPoint];
        num[breakPoint] = temp;
        int res = 0;
        
        Arrays.sort(num, breakPoint + 1, num.length);
        try {
            res = Integer.parseInt(new String(num));
        } catch (Exception e) {
            return -1;
        }
        
        return res < n ? -1 : res;
    }
}