// https://leetcode.com/problems/is-subsequence/
class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        for (; i < s.length(); i++) {
            boolean isFound = false;
            for (; j < t.length(); j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    isFound = true;
                    j++;
                    break;
                }
            }
            
            if (!isFound) return false;
            if (isFound && i == s.length() - 1) return true;
        }
        
        return true;
    }
}