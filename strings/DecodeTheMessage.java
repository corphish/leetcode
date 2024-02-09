// https://leetcode.com/problems/decode-the-message/
class Solution {
    public String decodeMessage(String key, String message) {
        StringBuilder sb = new StringBuilder();
        char[] map = new char[26];

        char x = 'a';
        for (char c : key.toCharArray()) {
            if (c == ' ')
                continue;
            if (map[c - 'a'] == 0) {
                map[c - 'a'] = x++;
            }
        }

        for (char c : message.toCharArray()) {
            if (c == ' ') {
                sb.append(' ');
                continue;
            }
            sb.append(map[c - 'a']);
        }

        return sb.toString();
    }
}