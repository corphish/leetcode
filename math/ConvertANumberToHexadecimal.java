// https://leetcode.com/problems/convert-a-number-to-hexadecimal
class Solution {
    public String toHex(int num) {
        long x = num < 0 ? (1L << 32) + num : num;
        String map = "0123456789abcdef";
        String res = "";

        while (x > 0) {
            res = map.charAt((int) (x % 16)) + res;
            x /= 16;
        }

        return res.isEmpty() ? "0" : res;
    }
}