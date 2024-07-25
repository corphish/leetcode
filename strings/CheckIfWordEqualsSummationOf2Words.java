// https://leetcode.com/problems/check-if-word-equals-summation-of-two-words/
class Solution {
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        return num(firstWord) + num(secondWord) == num(targetWord);
    }

    int num(String s) {
        int x = 0;
        for (char c: s.toCharArray()) {
            x = x * 10 + (c - 'a');
        }

        return x;
    }
}