// https://leetcode.com/problems/car-pooling/
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int maxTrip = 0;
        int[][] data = new int[1001][2];

        for (int[] trip: trips) {
            maxTrip = Math.max(maxTrip, trip[2]);
            data[trip[1]][0] += trip[0];
            data[trip[2]][1] -= trip[0];
        }
        
        int count = 0;
        for (int i = 0; i <= maxTrip; i++) {
            count += data[i][0];
            count += data[i][1];
            if (count > capacity) {
                return false;
            }
        }

        return true;
    }
}