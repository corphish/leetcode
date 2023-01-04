// https://leetcode.com/problems/maximum-value-after-insertion
class Solution {
    public String maxValue(String n, int x) {
        boolean isNegative = n.startsWith("-");

        int i = 0;
        for (; i < n.length() &&
               (isNegative ? n.charAt(i) - 48 <= x : n.charAt(i) - 48 >= x); i++);

        return n.substring(0, i) + x + n.substring(i);
    }
}