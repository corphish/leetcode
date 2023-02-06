// https://leetcode.com/problems/count-items-matching-a-rule
class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int key = ruleKey.equals("type") ? 0 : ruleKey.equals("color") ? 1 : 2;
        int res = 0;

        for (var x: items) {
            if (x.get(key).equals(ruleValue)) res++;
        }

        return res;
    }
}