// https://leetcode.com/problems/minimum-moves-to-convert-string
class Solution {
    public int minimumMoves(String s) {
       int count = 0;
       for (int i = 0; i < s.length();) {
           if (s.charAt(i) == 'O') {
               i++;
               continue;
           }
           boolean hasX = false;
           for (int j = i; j < Math.min(i + 3, s.length()); j++) {
               hasX |= s.charAt(j) == 'X';
           }
           
           if (hasX) count++;
           i += 3;
       } 
        
       return count;
    }
}