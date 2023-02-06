//https://leetcode.com/problems/flip-string-to-monotone-increasing/
// Unsolved
class Solution {
    public int minFlipsMonoIncr(String s) {
        int ones = 0, zeroes = 0;
        for (int i = s.indexOf('1'); i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '0') {
                zeroes++;
            } else {
                ones++;
            }

            if (zeroes > ones) {
                zeroes = ones;
            }
        }

        return zeroes;
    }
}