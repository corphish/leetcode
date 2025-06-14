// https://leetcode.com/problems/maximum-difference-by-remapping-a-digit
class Solution {
    public int minMaxDifference(int num) {
        String s = num + "";
        int max = num;
        int min = num;

        for (char c = '0'; c <= '9'; c++) {
            max = Math.max(max, Integer.parseInt(s.replace(c, '9')));
            min = Math.min(min, Integer.parseInt(s.replace(c, '0')));
        }

        return max - min;
    }
}