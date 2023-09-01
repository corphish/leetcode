// https://leetcode.com/problems/repeated-substring-pattern
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        StringBuilder pattern = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            pattern.append(s.charAt(i));

            if (i == s.length() - 1) break;

            boolean match = true;
            int k = 0;
            for (int j = i + 1; j < s.length(); j++, k++) {
                if (s.charAt(j) != s.charAt(k % pattern.length())) {
                    match = false;
                    break;
                }
            }

            if (match && k % pattern.length() == 0) {
                return true;
            }
        }

        return false;
    }
}