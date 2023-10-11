// https://leetcode.com/problems/shifting-letters/
class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        char[] c = s.toCharArray();
        long sum = 0;
        for (int i = shifts.length - 1; i >= 0; i--) {
            sum += shifts[i];
            long x = c[i] - 'a' + sum;
            c[i] = (char) ('a' + (x % 26));
        }

        return new String(c);
    }
}