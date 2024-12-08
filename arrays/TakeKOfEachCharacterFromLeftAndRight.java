// https://leetcode.com/problems/take-k-of-each-character-from-left-and-right
class Solution {
    public int takeCharacters(String s, int k) {
        if (k == 0) {
            return 0;
        }

        int min = s.length();
        int[] freq = new int[3];
        int j = -1;

        for (int i = s.length() - 1; i >= 0; i--) {
            freq[s.charAt(i) - 'a'] += 1;
            if (freq[0] >= k && freq[1] >= k && freq[2] >= k) {
                min = s.length() - i;
                break;
            }
        }

        Arrays.fill(freq, 0);

        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a'] += 1;

            if (j == -1) {
                for (j = s.length() - 1; j > i; j--) {
                    freq[s.charAt(j) - 'a'] += 1;
                    if (freq[0] >= k && freq[1] >= k && freq[2] >= k) {
                        break;
                    }
                }

                if (j == i) {
                    return -1;
                } else {
                    min = Math.min(min, (i + 1) + (s.length() - j));
                }
            } else {
                for (; j >= i && j < s.length(); j++) {
                    char c = s.charAt(j);
                    if (freq[c - 'a'] == k) break;
                    freq[c - 'a'] -= 1;
                }

                min = Math.min(min, (i + 1) + (s.length() - j));
            }
        }

        return min;
    }
}