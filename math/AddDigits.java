// https://leetcode.com/problems/add-digits
class Solution {
    public int addDigits(int num) {
        while (num > 9) {
            int sum = 0;
            for (; num > 0; num /= 10) sum += num % 10;
            num = sum;
        }
        
        return num;
    }
}