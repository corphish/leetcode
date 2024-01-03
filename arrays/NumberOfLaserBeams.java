// https://leetcode.com/problems/number-of-laser-beams-in-a-bank
class Solution {
    public int numberOfBeams(String[] bank) {
        int lastCount = 0, sum = 0;
        for (String s: bank) {
            int ones = 0;
            for(char c: s.toCharArray()) ones += c - '0';
            if (ones != 0) {
                if (lastCount != 0) {
                    sum += lastCount * ones;
                }
                lastCount = ones;
            }
        }
        
        return sum;
    }
}