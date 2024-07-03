// https://leetcode.com/problems/lexicographically-smallest-string-after-operations-with-constraint
class Solution {
    public String getSmallestString(String s, int k) {
        int sum = 0;
        char[] res = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            for (int j = 97; j < s.charAt(i); j++) {
                int score = Math.min(s.charAt(i) - j, j + 26 - s.charAt(i));
                if (score <= k - sum) {
                    sum += score;
                    res[i] = (char) j;
                    break;
                }
            }

            if (sum == k)
                break;
        }

        return new String(res);
    }
}