// https://leetcode.com/problems/two-best-non-overlapping-events
class Solution {
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        
        // maxStartingAt tells the max value of an event that starts on or after
        // a given time. maxStartingAt[i][0] holds the time and ..[i][1] holds the value
        // i is used for index in binary search.
        int[][] maxStartingAt = new int[events.length][2];
        int max = 0, k = events.length;
        int lastStartTime = -1;

        for (int i = k - 1; i >= 0; i--) {
            max = Math.max(max, events[i][2]);

            if (lastStartTime != events[i][0]) {
                lastStartTime = events[i][0];
                k -= 1;
            }

            maxStartingAt[k][0] = events[i][0];
            maxStartingAt[k][1] = max;
            
        }

        int res = 0;
        int[] search = new int[2];

        for (int[] event: events) {
            // Get the max value of any event starting at end time + 1 or later
            search[0] = event[1] + 1;
            int ix = Arrays.binarySearch(
                maxStartingAt, 
                k, 
                events.length,
                search,
                (a, b) -> a[0] - b[0]
            );

            if (ix < 0) {
                ix = -ix - 1;
            }

            if (ix >= 0 && ix < events.length) {
                res = Math.max(res, event[2] + maxStartingAt[ix][1]);
            } else {
                res = Math.max(res, event[2]);
            }
        }

        return res;
    }
}