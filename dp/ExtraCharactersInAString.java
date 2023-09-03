// https://leetcode.com/problems/extra-characters-in-a-string
class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        TrieNode root = new TrieNode();
        for (String word: dictionary) {
            TrieNode t = root;

            for (char c: word.toCharArray()) {
                int level = c - 'a';
                if (t.children[level] == null) {
                    t.children[level] = new TrieNode();
                }

                t = t.children[level];
            }

            t.isEnd = true;
            t.length = word.length();
        }

        char[] c = s.toCharArray();
        int[] memo = new int[s.length()];
        Arrays.fill(memo, - 1);

        return s.length() - getUsed(c, 0, root, memo);
    }

    int getUsed(char[] c, int start, TrieNode root, int[] memo) {
        if (start >= c.length) {
            return 0;
        }

        if (memo[start] != -1) {
            return memo[start];
        }

        TrieNode t = root;
        int max = 0;
        for (int i = start; i < c.length; i++) {
            int level = c[i] - 'a';
            t = t.children[level];

            if (t == null) {
                max = Math.max(max, getUsed(c, start + 1, root, memo));
                break;
            }
            else if (t.isEnd) {
                // We can choose to include this, or not include
                max = Math.max(
                    max,
                    t.length + getUsed(c, i + 1, root, memo)
                );
            }
        }

        // Check with start + 1 anyway if somehow it was missed.
        max = Math.max(max, getUsed(c, start + 1, root, memo));

        memo[start] = max;
        return max;
    }

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
        int length;
    }
}