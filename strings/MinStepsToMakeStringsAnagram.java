// https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram
class Solution {
    public int minSteps(String s, String t) {
        int[] freq = new int[26];
        for (char c: s.toCharArray()) freq[c - 'a']++;
        for (char c: t.toCharArray()) freq[c - 'a']--;

        int k = 0;

        for (int x: freq) k += Math.abs(x);

        return k/2;
    }
}