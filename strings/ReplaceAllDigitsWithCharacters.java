// https://leetcode.com/problems/replace-all-digits-with-characters/
class Solution {
    public String replaceDigits(String s) {
        char[] arr = s.toCharArray();

        for (int i = 1; i < s.length(); i += 2) {
            arr[i] = (char) ('a' + ((arr[i - 1] + arr[i] - 'a' - '0') % 26));
        }

        return new String(arr);
    }
}