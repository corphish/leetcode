// https://leetcode.com/problems/implement-strstr
class Solution {
    public int strStr(String s, String needle) {
        if (needle.isEmpty()) return 0;
        if (needle.length() > s.length()) return -1;
        int n = s.length(), j;
        
        for (int i = 0; i < n - needle.length() + 1; i++) {
            char a = s.charAt(i);
            if (a == needle.charAt(0)) {
                for (j = 1; j < needle.length(); j++) {
                    if (i + j >= n) break;
                    if (s.charAt(i + j) != needle.charAt(j)) break;
                }
                
                if (j == needle.length()) return i;
            }
        }
        
        return -1;
    }
}