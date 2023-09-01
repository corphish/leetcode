// https://leetcode.com/problems/minimum-penalty-for-a-shop
class Solution {
    public int bestClosingTime(String customers) {
        int n = customers.length();
        int[] open = new int[n];
        int[] closed = new int[n];

        for (int i = 0; i < n; i++) {
            char c = customers.charAt(i);
            if (i == 0) {
                if (c == 'Y') {
                    closed[i] = 1;
                } else {
                    open[i] = 1;
                }
            } else {
                if (c == 'Y') {
                    closed[i] = closed[i - 1] + 1;
                    open[i] = open[i - 1];
                } else {
                    open[i] = open[i - 1] + 1;
                    closed[i] = closed[i - 1];
                }
            }
        }

        int minPenalty = Integer.MAX_VALUE, res = -1;
        for (int i = 0; i <= n; i++) {
            int penalty;
            if (i == 0) {
                penalty = closed[n - 1];
            } else {
                penalty = closed[n - 1] - closed[i - 1] + open[i - 1];
            }

            if (penalty < minPenalty) {
                minPenalty = penalty;
                res = i;
            }
        }

        return res;
    }
}