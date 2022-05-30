// https://leetcode.com/problems/check-if-one-string-swap-can-make-strings-equal
class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        int f = -1;
        boolean swapped = false;
        
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (swapped) {
                    return false;
                }
                if (f == -1) {
                    f = i;
                } else {
                    if (s2.charAt(i) == s1.charAt(f) && s2.charAt(f) == s1.charAt(i)) {
                        swapped = true;
                        f = -1;
                    } else {
                        return false;
                    }
                }
            }
        }
        
        return f < 0;
    }
}