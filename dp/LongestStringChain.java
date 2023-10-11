// https://leetcode.com/problems/longest-string-chain
class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> b.length() - a.length());
        Map<String, Set<String>> validity = new HashMap<>();

        for (String w1: words) {
            for (String w2: words) {
                if (w1.length() - w2.length() == 1 && isValid(w1, w2)) {
                    validity.computeIfAbsent(w1, x -> new HashSet<>()).add(w2);
                }
            }
        }

        int[] memo = new int[words.length];
        int max = 0;
        for (int i = 0; i < words.length; i++)
            max = Math.max(max, max(words, i, validity, memo));

        return max + 1;
    }

    int max(String[] words, int i, Map<String, Set<String>> validity, int[] memo) {
        if (i >= words.length) {
            return 1;
        }

        if (memo[i] != 0) {
            return memo[i];
        }

        int max = 0;
        for (int j = i + 1; j < words.length; j++) {
            if (validity.containsKey(words[i]) && validity.get(words[i]).contains(words[j])) {
                max = Math.max(max, 1 + max(words, j, validity, memo));
            }
        }

        return memo[i] = max;
    }

    // a is the longer word
    boolean isValid(String a, String b) {
        boolean res = false;
        for (int i = 0; i < a.length(); i++) {
            String w = a.substring(0, i) + a.substring(i + 1);
            res |= w.equals(b);
        }

        return res;
    }
}