// https://leetcode.com/problems/buddy-strings
class Solution {
    // Checks:
    // 1. Frequency of each character in s must be same as that of each in goal.
    // 2. If difference in position mismatch is 2, swap can be done.
    // 3. If strings are equal, swap can be done if s contains any duplicate character.
    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        
        if (s.length() == 1) {
            return false;
        }
        
        int diff = 0;
        int[] freqS = new int[128];
        int[] freqGoal = new int[128];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                diff++;
            }
            
            freqS[s.charAt(i)]++;
            freqGoal[goal.charAt(i)]++;
        }
        
        for (int i = 0; i < 128; i++) {
            if (freqS[i] != freqGoal[i]) {
                return false;
            }
        }
        
        if (diff == 2) {
            return true;
        }
        
        if (diff == 0) {
            // It means the strings are equal
            // Check if there is a character that exists more than once
            // We can swap them and still have same value
            boolean hasDuplicateCharacter = false;
            for (int x: freqS) {
                hasDuplicateCharacter |= x > 1;
            }
            
            return hasDuplicateCharacter;
        }
        
        return false;
    }
}