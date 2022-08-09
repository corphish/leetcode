// https://leetcode.com/problems/corporate-flight-bookings
class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] res = new int[n];
        for (int[] book: bookings) {            
            res[book[0] - 1] += book[2];
            if (book[1] != n) {
                res[book[1]] -= book[2];
            }
        }
        
        for (int i = 1; i < n; i++) {
            res[i] += res[i - 1];
        }
        
        return res;
    }
}