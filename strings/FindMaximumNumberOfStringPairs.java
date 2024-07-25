// https://leetcode.com/problems/find-maximum-number-of-string-pairs/
class Solution {
    public int maximumNumberOfStringPairs(String[] words) {
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[i].equals(new StringBuffer(words[j]).reverse().toString())) {
                    count += 1;
                }
            }
        }

        return count;
    }
}