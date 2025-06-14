// https://leetcode.com/problems/count-vowel-strings-in-ranges
class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] count = new int[words.length];

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            char first = word.charAt(0);
            char last = word.charAt(word.length() - 1);

            int x = (first == 'a' || first == 'e' || first == 'i' || first == 'o' || first == 'u') && 
                (last == 'a' || last == 'e' || last == 'i' || last == 'o' || last == 'u') ? 1 : 0;

            if (i == 0) {
                count[i] = x;
            } else {
                count[i] = count[i - 1] + x;
            }
        }

        int[] res = new int[queries.length];
        for (int i = 0 ; i < res.length; i++) {
            int l = queries[i][0], r = queries[i][1];

            if (l == 0) {
                res[i] = count[r];
            } else {
                res[i] = count[r] - count[l - 1];
            }
        }

        return res;
    }
}