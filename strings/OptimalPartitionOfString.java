// https://leetcode.com/problems/optimal-partition-of-string
class Solution {
    public int partitionString(String s) {
        int[] freq = new int[26];
        int check = 1;

        for (char c: s.toCharArray()) {
            freq[c - 'a'] = Math.max(freq[c - 'a'] + 1, check);
            if (freq[c - 'a'] > check) {
                check++;
            }
        }

        return check;
    }
}