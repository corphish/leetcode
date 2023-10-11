// https://leetcode.com/problems/find-the-difference/
class Solution {
    public char findTheDifference(String s, String t) {
        int[] freq = new int[32];
        for (char c: t.toCharArray()) freq[c - 97]++;
        for (char c: s.toCharArray()) freq[c - 97]--;
        for (int i = 0; i < 32; i++) {
            if (freq[i] == 1) {
                return (char) (i + 97);
            }
        }
        
        return '-';
    }
}