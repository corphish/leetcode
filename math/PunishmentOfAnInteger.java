// https://leetcode.com/problems/find-the-punishment-number-of-an-integer
class Solution {
    public int punishmentNumber(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (check(i * i, i)) {
                sum += i * i;
            }
        }

        return sum;
    }

    boolean check(int square, int n) {
        if (square == n) {
            return true;
        }

        if (square < 1) {
            return false;
        }

        int r = 0;
        int k = 1;

        while (square > 0) {
            r = (square % 10) * k + r;
            square /= 10;
            k *= 10;
            if (check(square, n - r)) {
                return true;
            }
        }

        return false;
    }
}