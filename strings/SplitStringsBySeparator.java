// https://leetcode.com/problems/split-strings-by-separator
class Solution {
    public List<String> splitWordsBySeparator(List<String> words, char c) {
        List<String> res = new ArrayList<>();

        for (String w : words) {
            for (String p : w.split(".$|".contains("" + c) ? "\\" + c : "" + c)) {
                if (!p.isEmpty()) {
                    res.add(p);
                }
            }
        }

        return res;
    }
}