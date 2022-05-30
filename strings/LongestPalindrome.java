// https://leetcode.com/problems/longest-palindrome
class Solution {
    // Logic: Longest palindrome that can be formed will be using all the
    // characters which occur even number of times + frequency of all the characters
    // that occur odd number of times - 1 + 1 if there exists any character which occurs odd number of times.
    public int longestPalindrome(String s) {
        int[] freq = new int[128];
        int maxOdd = 0;
        int len = 0;
        
        for (char c: s.toCharArray()) {
            freq[c]++;
        }
        
        for (int x: freq) {
            if (x % 2 == 0) {
                len += x;
            } else {
                len += x - 1;
                maxOdd = Math.max(x, maxOdd);
            }
        }
        
        return len + (maxOdd != 0 ? 1 : 0);
    }
}