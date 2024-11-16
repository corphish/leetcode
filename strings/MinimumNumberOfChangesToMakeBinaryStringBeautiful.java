// https://leetcode.com/problems/minimum-number-of-changes-to-make-binary-string-beautiful
class Solution {
    public int minChanges(String s) {
        int count = 0;
        for (int i = 1; i < s.length(); i += 2) {
            count += Math.abs(s.charAt(i) - s.charAt(i - 1));
        }

        return count;
    }
}