// https://leetcode.com/problems/longest-palindrome-after-substring-concatenation-i/
class Solution {
    public int longestPalindrome(String s, String t) {
        int max = 1;
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length(); j >= i; j--) {
                String a = s.substring(i, j);

                for (int x = 0; x < t.length(); x++) {
                    for (int y = t.length(); y >= x; y--) {
                        String b = t.substring(x, y);
                        String c = a + b;

                        if (c.equals(new StringBuffer(c).reverse().toString())) {
                            max = Math.max(max, (j - i) + (y - x));
                        }
                    }
                }
            }
        }

        return max;
    }
}