// https://leetcode.com/problems/longest-palindrome-by-concatenating-two-letter-words/
class Solution {
    public int longestPalindrome(String[] words) {
        // 2 words, one of which is the reverse of the other.
        // the word may be palindrome.
        int reversePairs = 0;
        
        // 1 word, that is a palindrome but does not have a reverse
        int palindromes = 0;
        
        // Map to store reverse words
        Map<String, Integer> reverseMap = new HashMap<>();
        
        for (String s: words) {
            boolean isPalindrome = s.charAt(0) == s.charAt(1);
            String rev = s.charAt(1) + "" + s.charAt(0);
            
            if (reverseMap.getOrDefault(s, 0) > 0) {
                reversePairs++;
                reverseMap.put(s, reverseMap.get(s) - 1);
                
                if (isPalindrome) {
                    palindromes--;
                }
            } else if (isPalindrome) {
                palindromes++;
                reverseMap.put(rev, reverseMap.getOrDefault(rev, 0) + 1);
            } else {
                reverseMap.put(rev, reverseMap.getOrDefault(rev, 0) + 1);
            }
        }
        
        // We will only include 1 palindrome that are not in pair
        palindromes = palindromes > 0 ? 1 : 0;
        return (reversePairs * 4) + (palindromes * 2);
    }
}