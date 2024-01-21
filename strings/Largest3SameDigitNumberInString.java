// https://leetcode.com/problems/largest-3-same-digit-number-in-string
class Solution {
    public String largestGoodInteger(String num) {
        char m = '0';
        boolean found = false;
        for (int i = 2; i < num.length(); i++) {
            if (num.charAt(i) == num.charAt(i - 1) && num.charAt(i) == num.charAt(i - 2) && num.charAt(i) >= m) {
                m = num.charAt(i);
                found = true;
            }
        }

        return found ? "" + m + m + m : "";
    }
}