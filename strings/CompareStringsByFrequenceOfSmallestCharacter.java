// https://leetcode.com/problems/compare-strings-by-frequency-of-the-smallest-character/
class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] store = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            store[i] = freq(words[i]);
        }

        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int x = freq(queries[i]);
            int count = 0;

            for (int y: store) {
                if (x < y) count += 1;
            }

            res[i] = count;
        }

        return res;
    }

    int freq(String word) {
        int[] freq = new int[32];
        for (char c: word.toCharArray()) {
            freq[c - 'a']++;
        }

        for (int i = 0; i < 32; i++) {
            if (freq[i] > 0) return freq[i];
        }

        return 0;
    }
}