// https://leetcode.com/problems/string-compression-iii
class Solution {
    public String compressedString(String word) {
        char last = '-';
        int count = 1;
        StringBuilder sb = new StringBuilder();

        for (char c: word.toCharArray()) {
            if (last == '-') {
                last = c;
            } else if (c != last || count == 9) {
                sb.append(count).append(last);
                last = c;
                count = 1;
            } else {
                count += 1;
            }
        }

        sb.append(count).append(last);

        return sb.toString();
    }
}