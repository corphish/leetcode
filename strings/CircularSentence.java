// https://leetcode.com/problems/circular-sentence/
class Solution {
    public boolean isCircularSentence(String sentence) {
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            String next = words[(i + 1) % words.length];
            if (words[i].charAt(words[i].length() - 1) != next.charAt(0)) {
                return false;
            }
        }

        return true;
    }
}