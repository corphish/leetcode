// https://leetcode.com/problems/minimum-length-of-string-after-operations/
class Solution {
    public int minimumLength(String s) {
        int[] freq = new int[26];
        for (char c: s.toCharArray()) {
            freq[c - 'a'] += 1;
        }

        int sum = 0;
        for (int x: freq) {
            if (x > 0) {
                sum += x % 2 == 0 ? 2 : 1;
            }
        }

        return sum;
    }
}