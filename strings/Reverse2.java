// https://leetcode.com/problems/reverse-string-ii
class Solution {
    public String reverseStr(String s, int k) {
        int p = 0;
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < s.length(); i += k, p++) {
            String sub = s.substring(i, Math.min(i + k, s.length()));
            if (p % 2 == 0) {
                sub = new StringBuffer(sub).reverse().toString();
            }
            
            sb.append(sub);
        }
        
        return sb.toString();
    }
}