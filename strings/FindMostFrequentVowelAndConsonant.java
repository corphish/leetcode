// https://leetcode.com/problems/find-most-frequent-vowel-and-consonant/
class Solution {
    public int maxFreqSum(String s) {
        int[] freq = new int[32];
        for (char c: s.toCharArray()) {
            freq[c - 'a'] += 1;
        }

        int a = 0, b = 0;
        for (int i = 0; i < 32; i++) {
            if (i == 0 || i == 4 || i == 8 || i == 14 || i == 20) {
                a = Math.max(a, freq[i]);
            } else {
                b = Math.max(b, freq[i]);
            }
        }

        return a + b;
    }
}