// https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons
class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> a[0] - b[0]);
        int rangeMin = points[0][0], rangeMax = points[0][1];
        int count = 1;

        for (int i = 1; i < points.length; i++) {
            if ((points[i][0] >= rangeMin && points[i][0] <= rangeMax) || (points[i][1] >= rangeMin && points[i][1] <= rangeMax)) {
                rangeMin = Math.max(rangeMin, points[i][0]);
                rangeMax = Math.min(rangeMax, points[i][1]);
            } else {
                count += 1;
                rangeMin = points[i][0];
                rangeMax = points[i][1];
            }
        }

        return count;
    }
}