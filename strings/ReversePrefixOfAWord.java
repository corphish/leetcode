// https://leetcode.com/problems/reverse-prefix-of-word
class Solution {
    public String reversePrefix(String word, char ch) {
        int ix = word.indexOf(ch);
        if (ix < 0) return word;

        return new StringBuffer(word.substring(0, ix + 1)).reverse() + word.substring(ix + 1);
    }
}