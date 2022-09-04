// https://leetcode.com/problems/calculate-digit-sum-of-a-string/
class Solution {
    public String digitSum(String s, int k) {
        while (s.length() > k) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i += k) {
                sb.append(digitSum(s.substring(i, Math.min(i + k, s.length()))));
            }
            s = sb.toString();
        }
        
        return s;
    }
    
    long digitSum(String s) {
        return s.chars().map(i -> i - 48).sum();
    }
}