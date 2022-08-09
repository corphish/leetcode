// https://leetcode.com/problems/check-if-the-sentence-is-pangram
class Solution {
    public boolean checkIfPangram(String sentence) {
        int[] freq = new int[26];
        for (char c: sentence.toCharArray()) {
            freq[c - 'a']++;
        }
        
        boolean isPangram = true;
        for (int x: freq) isPangram &= x > 0;
        
        return isPangram;
    }
}