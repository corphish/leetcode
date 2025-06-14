// https://leetcode.com/problems/maximum-score-after-splitting-a-string
class Solution {
    public int maxScore(String s) {
        int x = 0, y = 0, max = 0;

        for (char c: s.toCharArray()) {
            y += c - '0';
        }

        for (int i = 0; i < s.length() - 1; i++) {
            char c = s.charAt(i);
            if (c == '0') {
                x += 1;
            } else {
                y -= 1;
            }

            max = Math.max(max, x + y);
        }

        return max;
    }
}