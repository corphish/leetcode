// https://leetcode.com/problems/largest-odd-number-in-string
class Solution {
    public String largestOddNumber(String num) {
        int i = num.length() - 1;
        for (; i >= 0 && (num.charAt(i) - 48) % 2 == 0; i--);
        return num.substring(0, i + 1);
    }
}