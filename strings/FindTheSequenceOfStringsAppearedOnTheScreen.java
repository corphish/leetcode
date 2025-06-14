// https://leetcode.com/problems/find-the-sequence-of-strings-appeared-on-the-screen
class Solution {
    public List<String> stringSequence(String target) {
        List<String> res = new ArrayList<>();
        char[] temp = new char[target.length()];
        int pos = 0;

        for (int i = 0; i < target.length(); i++) {
            char c = target.charAt(i);
            for (char j = 'a'; j <= c; j++) {
                temp[pos] = j;
                res.add(new String(temp, 0, pos + 1));
            }

            pos += 1;
        }

        return res;
    }
}