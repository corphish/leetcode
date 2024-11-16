// https://leetcode.com/problems/sentence-similarity-iii
class Solution {
    public boolean areSentencesSimilar(String a, String b) {
        String big = a.length() > b.length() ? a : b;
        String small = a.length() > b.length() ? b : a;

        String[] bigWords = big.split(" ");
        String[] smallWords = small.split(" ");

        int l = 0, r = 0;

        for (; l < smallWords.length && bigWords[l].equals(smallWords[l]); l++);
        for (; r < smallWords.length && bigWords[bigWords.length - 1 - r].equals(smallWords[smallWords.length - 1 - r]); r++);

        return l + r >= smallWords.length;
    }
}