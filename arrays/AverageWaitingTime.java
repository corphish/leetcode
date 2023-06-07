// https://leetcode.com/problems/average-waiting-time
class Solution {
    public double averageWaitingTime(int[][] customers) {
        double wait = 0.0;
        int time = 0;

        for (int[] order: customers) {
            time = Math.max(time, order[0]);
            time += order[1];
            wait += time - order[0];
        }

        return wait/customers.length;
    }
}