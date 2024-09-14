// https://leetcode.com/problems/count-the-number-of-consistent-strings/
class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int[] freq = new int[26];
        for (char c: allowed.toCharArray()) freq[c - 'a'] += 1;

        int count = 0;
        for (String word: words) {
            boolean flag = true;
            for (char c: word.toCharArray()) {
                if (freq[c - 'a'] == 0) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                count += 1;
            }
        }

        return count;
    }
}