// https://leetcode.com/problems/number-of-lines-to-write-string/
class Solution {
    public int[] numberOfLines(int[] widths, String s) {
        int lines = 1, rem = 100;
        for (char c : s.toCharArray()) {
            int w = widths[c - 'a'];
            if (w > rem) {
                lines += 1;
                rem = 100 - w;
            } else {
                rem -= w;
            }
        }

        return new int[] { lines, 100 - rem };
    }
}