// https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold
class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int k = 0;
        for (int x: nums) {
            k = Math.max(x, k);
        }

        int low = 1, high = k, min = k;
        while (low < high) {
            int sum = 0;
            int mid = (low + high)/2;
            for (int x: nums) {
                sum += x % mid == 0 ? x/mid : x/mid + 1;
            }

            if (sum > threshold && mid == min - 1) {
                return min;
            }

            if (sum > threshold) {
                low = mid;
            } else {
                min = Math.min(min, mid);
                high = mid;
            }
        }

        return 1;
    }
}