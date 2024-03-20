// https://leetcode.com/problems/generate-a-string-with-characters-that-have-odd-counts
class Solution {
    public String generateTheString(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < (n % 2 == 1 ? n : n - 1); i++) {
            sb.append('a');
        }    

        if (n % 2 == 0) {
            sb.append('b');
        }

        return sb.toString();
    }
}