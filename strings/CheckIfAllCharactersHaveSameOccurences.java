// https://leetcode.com/problems/check-if-all-characters-have-equal-number-of-occurrences/
class Solution {
    public boolean areOccurrencesEqual(String s) {
        int[] freq = new int[26];
        for (char c: s.toCharArray()) {
            freq[c - 'a'] += 1;
        }

        int last = -1;
        for (int x: freq) {
            if (x == 0) continue;
            if (last == -1) {
                last = x;
            } else if (x != last) {
                return false;
            }
        }

        return true;
    }
}