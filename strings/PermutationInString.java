// https://leetcode.com/problems/permutation-in-string/
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] freq = new int[32];
        int tLen = s1.length(), rLen = 0, lastI = 0;
        for (char c: s1.toCharArray()) {
            freq[c - 97]++;
        }
        
        if (s1.length() > s2.length()) return false;
        
        int[] temp = freq.clone();
        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            if (temp[c - 97] <= 0) {
                i = i - rLen;
                rLen = 0;
                temp = freq.clone();
            } else {
                temp[c - 97]--;
                rLen++;
            }
            
            if (rLen == tLen) return true;
        }
        
        return false;
    }
}