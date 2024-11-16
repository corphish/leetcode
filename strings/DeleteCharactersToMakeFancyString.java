// https://leetcode.com/problems/delete-characters-to-make-fancy-string
class Solution {
    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();
        char last = '-';
        int count = 0;

        for (char c: s.toCharArray()) {
            if (c != last) {
                last = c;
                count = 1;
                sb.append(c);
            } else {
                count += 1;
                if (count > 2) {
                    continue;
                } else {
                    count += 1;
                    sb.append(c);
                }
            }
        }

        return sb.toString();
    }
}