// https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets
class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int lower = Integer.MAX_VALUE, upper = 0;
        for (int x: bloomDay) {
            upper = Math.max(upper, x);
            lower = Math.min(lower, x);
        }

        int last = -1;

        while (lower <= upper) {
            int mid = (lower + upper)/2;
            if (check(bloomDay, mid, m, k)) {
                last = mid;
                upper = mid - 1;
            } else {
                lower = mid + 1;
            }
        }

        return last;
    }

    boolean check(int[] arr, int d, int m, int k) {
        int count = 0, adj = 0;
        for (int x: arr) {
            if (x <= d) {
                adj += 1;
            } else {
                adj = 0;
            }

            if (adj == k) {
                adj = 0;
                count += 1;
            }
        }

        return count >= m;
    }
}