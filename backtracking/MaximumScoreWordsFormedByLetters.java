// https://leetcode.com/problems/maximum-score-words-formed-by-letters
class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] freq = new int[26];
        for (char c: letters) {
            freq[c - 'a']++;
        }

        return max(words, freq, score, 0);
    }

    int max(String[] words, int[] freq, int[] scores, int i) {
        if (i >= words.length) {
            return 0;
        }

        int max = 0;

        // Compute the score of words[i]
        int score = 0;
        boolean canForm = true;
        for (char c: words[i].toCharArray()) {
            if (freq[c - 'a'] == 0) {
                score = 0;
                canForm = false;
            }

            freq[c - 'a'] -= 1;
            if (canForm)
                score += scores[c - 'a'];
        }

        // Consider this word and get the max
        if (score != 0) {
            max = score + max(words, freq, scores, i + 1);
        }

        // Backtrack
        for (char c: words[i].toCharArray()) {
            freq[c - 'a'] += 1;
        }

        max = Math.max(max, max(words, freq, scores, i + 1));

        return max;
    }
}