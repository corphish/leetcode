// https://leetcode.com/problems/decode-ways
class Solution {
    public int numDecodings(String s) {
        char[] digits = s.toCharArray();
        int[] dp = new int[s.length()];
        dp[0] = digits[0] == '0' ? 0 : 1;
        
        for (int i = 1; i < digits.length; i++) {
            if (digits[i] == '0' && (digits[i - 1] == '0' || digits[i - 1] > '2')) {
                // Cannot form 00, 30, 40, ..
                return 0;
            }
            
            // If at this point the we can decode, we should be able to decode the string up until this
            // character the same as we could do for i - 1 characters, given that the new digit is not 0
            if (digits[i] != '0')
                dp[i] = dp[i - 1];
            
            // We can make additional combo if i and i - 1 chars combine to form valid letters.
            if (digits[i - 1] == '1' || (digits[i - 1] == '2' && digits[i] < '7')) {
                if (i == 1) {
                    dp[i]++;
                } else {
                    dp[i] += dp[i - 2];
                }
            }
        }
        
        return dp[dp.length - 1];
    }
}