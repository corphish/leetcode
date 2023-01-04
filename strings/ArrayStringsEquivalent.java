// https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent
class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder a = new StringBuilder();
        StringBuilder b = new StringBuilder();
        
        for (String word: word1) a.append(word);
        for (String word: word2) b.append(word);
        
        return a.toString().equals(b.toString());
    }
}