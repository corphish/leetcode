// https://leetcode.com/problems/percentage-of-letter-in-string
class Solution {
    public int percentageLetter(String s, char letter) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char c: s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        return (freq.getOrDefault(letter, 0) * 100)/s.length();
    }
}