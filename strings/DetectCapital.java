// https://leetcode.com/problems/detect-capital/
class Solution {
    public boolean detectCapitalUse(String word) {
        return word.matches("[A-Z]+") || word.matches("[A-Z][a-z]+") || word.matches("[a-z]+");
    }
}