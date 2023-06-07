// https://leetcode.com/problems/find-the-longest-valid-obstacle-course-at-each-position
class Solution {
    public int[] longestObstacleCourseAtEachPosition(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        int[] track = new int[n + 1];

        Arrays.fill(track, Integer.MAX_VALUE);
        track[0] = 0;

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                res[i] = 1;
                track[1] = arr[i];
            } else {
                int ix = Arrays.binarySearch(track, 0, i + 1, arr[i]);
                if (ix >= 0) {
                    for (; ix < n && track[ix] == arr[i]; ix++);
                    res[i] = ix;
                    track[ix] = arr[i];
                } else {
                    // Should never be 0
                    ix = -ix - 1;
                    res[i] = ix;
                    track[ix] = Math.min(track[ix], arr[i]);
                }
            }
        }

        return res;
    }
}