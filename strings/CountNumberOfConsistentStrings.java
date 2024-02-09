// https://leetcode.com/problems/count-the-number-of-consistent-strings/
class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int count = 0;
        for (String word: words) {
            boolean add = true;
            for (char c: word.toCharArray()) {
                if (!allowed.contains("" + c)) {
                    add = false;
                }
            }

            if (add) count += 1;
        }

        return count;
    }
}