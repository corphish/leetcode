// https://leetcode.com/problems/find-words-containing-character/
class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].contains("" + x)) {
                res.add(i);
            }
        }

        return res;
    }
}