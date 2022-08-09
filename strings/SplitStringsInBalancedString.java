// https://leetcode.com/problems/split-a-string-in-balanced-strings
class Solution {
    public int balancedStringSplit(String s) {
        int count = 0, x = 0;
        for (char c: s.toCharArray()) {
            if (c == 'L') {
                x++;
            } else {
                x--;
            }
            
            count += x == 0 ? 1 : 0;
        }
        
        return count;
    }
}