// https://leetcode.com/problems/minimum-time-to-complete-trips/
class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        Arrays.sort(time);
        int last = time[time.length - 1];
        long upper = 1L * last * totalTrips, lower = 0, lastPossibleRes = -1;
        Map<Long, Long> map = new HashMap<>();

        while (lower <= upper) {
            long mid = (lower + upper)/2;
            long x = trips(time, mid);

            map.put(mid, x);

            if (x > totalTrips) {
                upper = mid - 1;
                if (map.containsKey(upper) && map.get(upper) < x) {
                    return mid;
                }
                if (upper < lower && lastPossibleRes == -1) {
                    lower /= 2;
                }
            } else if (x < totalTrips) {
                lower = mid + 1;
                if (map.containsKey(lower) && map.get(lower) >= x) {
                    return lower;
                }

                if (lower > upper && lastPossibleRes == -1) {
                    upper *= 2;
                }
            } else {
                upper = mid - 1;
                lastPossibleRes = mid;
            }
        }

        return lastPossibleRes;
    }

    long trips(int[] arr, long time) {
        long count = 0;
        for (int x: arr) {
            count += time/x;
        }

        return count;
    }
}