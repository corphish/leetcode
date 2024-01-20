// https://leetcode.com/problems/total-appeal-of-a-string
class Solution {
    public long appealSum(String s) {
        long sum = 0;
        for (int ch = 'a'; ch <= 'z'; ch++) {
            int last = -1;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == (char) ch) {
                    last = j;
                }

                sum += last + 1;
            }
        }

        return sum;
    }
}