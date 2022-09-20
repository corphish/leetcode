// https://leetcode.com/problems/optimal-partition-of-string
class Solution {
    public int partitionString(String s) {
        int[] freq = new int[26];
        int count = 1;
        
        for (char c: s.toCharArray()) {
            if (freq[c - 'a'] > 0) {
                count++;
                Arrays.fill(freq, 0);
            }
            
            freq[c - 'a']++;
        }
        
        return count;
    }
}