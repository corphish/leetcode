// https://leetcode.com/problems/reverse-words-in-a-string
class Solution {
    public String reverseWords(String s) {
        String[] p = s.split("[ ]+");
        String res = "";
        for (int i = p.length - 1; i >= 0; i--)
            res += p[i] + " ";
        
        return res.trim();
    }
}