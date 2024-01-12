// https://leetcode.com/problems/determine-if-string-halves-are-alike
class Solution {
    public boolean halvesAreAlike(String s) {
        int n = s.length();
        return s.substring(0, n/2).replaceAll("[aeiouAEIOU]", "").length() == s.substring(n/2).replaceAll("[aeiouAEIOU]", "").length();
    }
}