class Solution {
    // https://leetcode.com/problems/find-the-student-that-will-replace-the-chalk
    public int chalkReplacer(int[] chalk, int k) {
        long sum = 0;
        for (int x: chalk) {
            sum += x;
        }

        k %= sum;
        sum = 0;
        int i = 0;

        for (int x: chalk) {
            sum += x;
            if (k < sum) {
                return i;
            }

            i += 1;
        }

        return -1;
    }
}