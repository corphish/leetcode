// https://leetcode.com/problems/adding-spaces-to-a-string
class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();
        int last = 0;
        for (int sp: spaces) {
            sb.append(s.substring(last, sp)).append(' ');
            last = sp;
        }

        if (last < s.length()) {
            sb.append(s.substring(last));
        }

        return sb.toString();
    }
}