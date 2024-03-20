// https://leetcode.com/problems/maximum-number-of-balloons/
class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] freq = new int[26];
        for (char c : text.toCharArray()) {
            freq[c - 'a'] += 1;
        }

        return Math.min(
                freq['b' - 'a'],
                Math.min(
                        freq['a' - 'a'],
                        Math.min(
                                freq['l' - 'a'] / 2,
                                Math.min(
                                        freq['o' - 'a'] / 2,
                                        freq['n' - 'a']))));
    }
}