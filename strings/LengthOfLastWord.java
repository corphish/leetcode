// https://leetcode.com/problems/length-of-last-word
class Solution {
    public int lengthOfLastWord(String s) {
        String[] p = s.trim().split("[ ]{1,}");
        return p[p.length - 1].length();
    }
}