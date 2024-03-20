// https://leetcode.com/problems/find-words-that-can-be-formed-by-characters
class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] freq = new int[32];
        int res = 0;
        for (char c: chars.toCharArray()) freq[c - 'a']++;

        for (String w: words) {
            boolean match = true;
            for (char c: w.toCharArray()) {
                if (freq[c - 'a'] == 0) {
                    match = false;
                }

                freq[c - 'a'] -= 1;
            }

            for (char c: w.toCharArray()) freq[c - 'a']++;

            if (match) res += w.length();
        }


        return res;
    }
}