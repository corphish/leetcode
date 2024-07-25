// https://leetcode.com/problems/count-symmetric-integers/
class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int count = 0;
        for (int i = low; i <= high; i++) {
            if (check(i)) count += 1;
        }

        return count;
    }

    boolean check(int n) {
        String x = "" + n;
        if (x.length() % 2 == 1) {
            return false;
        }

        int sum = 0;
        for (int i = 0; i < x.length(); i++) {
            if (i < x.length()/2) {
                sum += x.charAt(i);
            } else {
                sum -= x.charAt(i);
            }
        }

        return sum == 0;
    }
}