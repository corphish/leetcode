// https://leetcode.com/problems/reconstruct-original-digits-from-english/
class Solution {
    String[] w = {
        "zero",
        "one",
        "two",
        "three",
        "four",
        "five",
        "six",
        "seven",
        "eight",
        "nine"
    };

    public String originalDigits(String s) {
        int[] res = new int[10];
        int[] freq = new int[26];
        StringBuilder sb = new StringBuilder();

        // Process even digits first
        for (char c: s.toCharArray()) {
            freq[c - 'a'] += 1;

            if (c == 'z') {
                res[0] += 1;
            } else if (c == 'w') {
                res[2] += 1;
            } else if (c == 'u') {
                res[4] += 1;
            } else if (c == 'x') {
                res[6] += 1;
            } else if (c == 'g') {
                res[8] += 1;
            }
        }

        for (int i = 0; i < 10; i += 2) {
            for (char c: w[i].toCharArray()) {
                freq[c - 'a'] -= res[i];
            }
        }

        for (int i = 0; i < 26; i++) {
            res[1] = freq['o' - 'a'];
            res[3] = freq['t' - 'a'];
            res[5] = freq['f' - 'a'];
            res[7] = freq['s' - 'a'];
            res[9] = (freq['n' - 'a'] - res[7] - res[1])/2;
        }

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < res[i]; j++) {
                sb.append(i);
            }
        }

        return sb.toString();
    }
}