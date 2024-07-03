// https://leetcode.com/problems/minimum-number-of-operations-to-make-word-k-periodic/
class Solution {
    public int minimumOperationsToMakeKPeriodic(String word, int k) {
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> freq = new HashMap<>();
        int max = 0;

        for (int i = 0; ; i++) {
            if (i % k == 0 && i > 0) {
                String s = sb.toString();
                int x = freq.getOrDefault(s, 0) + 1;
                freq.put(s, x);
                max = Math.max(max, x);
                sb.setLength(0);
            }

            if (i == word.length()) {
                break;
            }

            sb.append(word.charAt(i));
        }

        return (word.length() - (k * max))/k;
    }
}