// https://leetcode.com/problems/harshad-number/
class Solution {
    public int sumOfTheDigitsOfHarshadNumber(int x) {
        int sum = sum(x);

        return x % sum == 0 ? sum : -1;
    }

    int sum(int x) {
        int sum = 0;
        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }

        return sum;
    }
}