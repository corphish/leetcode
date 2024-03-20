// https://leetcode.com/problems/minimum-number-of-pushes-to-type-word-ii/
class Solution {
    public int minimumPushes(String word) {
        int[] freq = new int[26];
        int cost = 0;

        for (char c: word.toCharArray()) {
            freq[c - 'a'] += 1;
        }

        int index = 0;

        while (true) {
            int max = 0, k = 0;
            for (int i = 0; i < 26; i++) {
                if (freq[i] > max) {
                    max = freq[i];
                    k = i;
                }
            }

            if (max > 0) {
                cost += max * (index/8 + 1);
                freq[k] = 0;
                index += 1;
            } else {
                break;
            }
        }

        return cost;
    }
}