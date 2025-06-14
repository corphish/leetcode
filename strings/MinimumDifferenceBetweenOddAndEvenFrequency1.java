// https://leetcode.com/problems/maximum-difference-between-even-and-odd-frequency-i
class Solution {
    public int maxDifference(String s) {
        int[] freq = new int[26];
        for (char c: s.toCharArray()) {
            freq[c - 'a'] += 1;
        }

        int maxOdd = 0, minOdd = s.length();
        int maxEven = 0, minEven = s.length();

        for (int x: freq) {
            if (x != 0) {
                if (x % 2 == 0) {
                    maxEven = Math.max(maxEven, x);
                    minEven = Math.min(minEven, x);
                } else {
                    maxOdd = Math.max(maxOdd, x);
                    minOdd = Math.min(minOdd, x);
                }
            }
        }

        return maxOdd - minEven;
    }
}