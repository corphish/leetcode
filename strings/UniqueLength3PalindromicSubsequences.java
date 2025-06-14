// https://leetcode.com/problems/unique-length-3-palindromic-subsequences
class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length(), count = 0;
        int[][] ix = new int[26][n];
        int[] pos = new int[26];

        for (int[] row: ix) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        int i = 0;
        for (char c: s.toCharArray()) {
            ix[c - 'a'][pos[c - 'a']] = i;
            i += 1;
            pos[c - 'a'] += 1;
        }

        for (i = 0; i < 26; i++) {
            int first = ix[i][0];
            if (pos[i] - 1 < 0) continue;
            int last = ix[i][pos[i] - 1];
            for (int j = 0; j < 26; j++) {
                int k = Arrays.binarySearch(ix[j], first + 1);
                if (k < 0) {
                    k = -k - 1;
                }

                if (ix[j][k] > first && ix[j][k] < last) {
                    count += 1;
                }
            }
        }

        return count;
    }
}