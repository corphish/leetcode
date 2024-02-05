// https://leetcode.com/problems/first-unique-character-in-a-string
class Solution {
    public int firstUniqChar(String s) {
        int[] freq = new int[128];
        for (char c: s.toCharArray()) {
            freq[c]++;
        }
        
        int i = 0;
        for (char c: s.toCharArray()) {
            if (freq[c] == 1) {
                return i;
            }
            i++;
        }
        
        return -1;
    }
}