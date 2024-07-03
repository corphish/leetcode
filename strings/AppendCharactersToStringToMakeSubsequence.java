// https://leetcode.com/problems/append-characters-to-string-to-make-subsequence
class Solution {
    public int appendCharacters(String s, String t) {
        int p = 0, m = s.length(), n = t.length();
        for (int i = 0; i < m && p < n; i++) {
            if (s.charAt(i) == t.charAt(p)) {
                p++;
            }
        }

        return n - p;
    }
}