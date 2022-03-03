// https://leetcode.com/problems/add-strings
class Solution {
    public String addStrings(String num1, String num2) {
        int maxLen = Math.max(num1.length(), num2.length());
        num1 = zeroPad(num1, maxLen);
        num2 = zeroPad(num2, maxLen);
        
        //System.out.println(num1);
        
        char[] res = new char[maxLen];
        int carry = 0;
        
        for (int i = maxLen - 1; i >= 0; i--) {
            char a = num1.charAt(i);
            char b = num2.charAt(i);
            
            int sum = (a - 48) + (b - 48) + carry;
            res[i] = (char) (sum % 10 + 48);
            carry = sum/10;
        }
        
        return (carry > 0 ? carry : "") + new String(res);
    }
    
    String zeroPad(String num, int targetLen) {
        StringBuilder sb = new StringBuilder(num);
        while (sb.length() < targetLen) {
            sb.insert(0, "0");
        }
        
        return sb.toString();
    }
}