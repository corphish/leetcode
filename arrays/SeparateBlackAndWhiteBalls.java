// https://leetcode.com/problems/separate-black-and-white-balls
class Solution {
    public long minimumSteps(String s) {
        long sum = 0;
        int count = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                count += 1;
            } else {
                sum += count;
            }
        }

        return sum;
    }
}