// https://leetcode.com/problems/reverse-bits
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        String binary = Integer.toBinaryString(n);
        String padded = String.format("%32s", binary).replace(' ', '0');
        String reversed = new StringBuffer(padded).reverse().toString();
        return (int) Long.parseLong(reversed, 2);
    }
}