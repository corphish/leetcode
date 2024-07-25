// https://leetcode.com/problems/count-asterisks/
class Solution {
    public int countAsterisks(String s) {
        int res = 0;
        int count = 0;

        for (char c: s.toCharArray()) {
            if (c == '*' && count % 2 == 0) {
                res += 1;
            } else if (c == '|') {
                count += 1;
            }
        }

        return res;
    }
}