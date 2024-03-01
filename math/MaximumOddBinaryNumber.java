// https://leetcode.com/problems/maximum-odd-binary-number/
class Solution {
    public String maximumOddBinaryNumber(String s) {
        s = s.replaceFirst("1", "0");
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        arr[0] = '1';

        return new StringBuffer(new String(arr)).reverse().toString();
    }
}