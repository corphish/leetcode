// https://leetcode.com/problems/find-first-palindromic-string-in-the-array/
class Solution {
    public String firstPalindrome(String[] words) {
        for (String word: words) {
            if (new StringBuffer(word).reverse().toString().equals(word)) {
                return word;
            }
        }
        
        return "";
    }
}