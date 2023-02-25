// https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int sum = 0, avg = 0, max = 0;

        for (int x: weights) {
            sum += x;
            max = Math.max(max, x);
        }

        if (sum % days == 0) {
            avg = sum/days;
        } else {
            avg = sum/days + 1;
        }

        int possibleAnswer = Math.max(avg, max);

        for (int i = 1; i < weights.length; i++) {
            weights[i] += weights[i - 1];
        }

        int low = 0, high = possibleAnswer * 2;
        Map<Integer, Boolean> map = new HashMap<>();

        while (low <= high) {
            int mid = (low + high)/2;

            boolean r1 = map.computeIfAbsent(mid, x -> isPossible(weights, mid, days));
            boolean r2 = map.computeIfAbsent(mid - 1, x -> isPossible(weights, mid - 1, days));

            if (r1 && !r2) {
                return mid;
            }

            if (r1 && r2) {
                high = mid - 1;
            }

            if (!r1 && !r2) {
                low = mid + 1;
            }
        }

        return low;
    }

    boolean isPossible(int[] prefix, int capacity, int days) {
        int sum = 0;
        int lastPosition = -1;
        int time = 0;

        while (lastPosition < prefix.length - 1) {
            int ix = Arrays.binarySearch(prefix, sum + capacity);
            if (ix < 0) ix = -ix - 2;

            if (ix == lastPosition) return false;
            sum = prefix[ix];
            lastPosition = ix;
            time++;
        }

        return time <= days;
    }
}