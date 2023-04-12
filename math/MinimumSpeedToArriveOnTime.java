// https://leetcode.com/problems/minimum-speed-to-arrive-on-time/
class Solution {
    final int MAX_UPPER_BOUND = Integer.MAX_VALUE/2;

    public int minSpeedOnTime(int[] dist, double hour) {
        // Minimum time it will take to reach if we can travel at speed that tends to infinity?
        // If we could travel at the speed, then each dist[i] could be covered in time that tends to 0 hrs.
        // But we would have to wait the remaining part of the hour to be able to board the next train.
        // So it would take (n - 1) hours to travel the first (n - 1) train.
        // Then the last train could cover its distance in time that tends to 0 hrs.
        // So minimum time it would take = n - 1 hours.
        int minTime = dist.length - 1;

        // If the allocated hours is less than the minTime, we cannot reach the office.
        if (hour < minTime) {
            return -1;
        }

        // Since the speed has to be int, the minimum speed it can travel it can travel is 1 km/h.
        int lowerBound = 1;

        // Upper bound we take as high value as possible.
        int upperBound = MAX_UPPER_BOUND;
        int minSpeed = upperBound;

        while (lowerBound < upperBound) {
            int mid = (lowerBound + upperBound)/2;
            if (canTravelInTime(dist, mid, hour)) {
                minSpeed = Math.min(minSpeed, mid);
                upperBound = mid;
            } else {
                if (minSpeed - mid == 1) {
                    return minSpeed == MAX_UPPER_BOUND ? -1 : minSpeed;
                } else {
                    lowerBound = mid;
                }
            }
        }

        return minSpeed == MAX_UPPER_BOUND ? -1 : minSpeed;
    }

    boolean canTravelInTime(int[] dist, int speed, double hour) {
        double time = 0;
        for (int i = 0; i < dist.length - 1; i++) {
            time += Math.ceil((dist[i] * 1.0)/speed);
        }

        time += (dist[dist.length - 1] * 1.0)/speed;
        return time <= hour;
    }
}