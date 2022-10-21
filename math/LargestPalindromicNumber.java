// https://leetcode.com/problems/largest-palindromic-number
class Solution {
    public String largestPalindromic(String num) {
        int[] freq = new int[10];
        String res = "";
        
        for (char c: num.toCharArray()) {
            freq[c - '0']++;
        }
        
        // Add 1 from the largest digit with odd freq 
        for (int i = 9; i >= 0; i--) {
            if (freq[i] % 2 == 1) {
                res += i;
                freq[i]--;
                break;
            }
        }
        
        // Spread rest of them
        for (int i = 0; i < 10; i++) {
            if (freq[i] > 1) {
                String part = repeat(i, freq[i]/2);
                res = part + res + part;
            }
        }
        
        return leadingZeroesCorrected(res);
    }
    
    String leadingZeroesCorrected(String num) {
        boolean isLeading = num.startsWith("0");
        int nonZeroIndex = -1;
        
        if (!isLeading) {
            return num;
        }
        
        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i) != '0') {
                nonZeroIndex = i;
                break;
            }
        }
        
        return nonZeroIndex < 0 ? "0" : largestPalindromic(num.substring(nonZeroIndex));
    }
    
    String repeat(int x, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(x);
        }
        
        return sb.toString();
    }
}