// https://leetcode.com/problems/minimized-maximum-of-products-distributed-to-any-store
class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int max = 0;
        for (int x: quantities) max = Math.max(max, x);
        int low = 0, high = max;
        int min = high;
        while (low <= high) {
            int mid = (low + high)/2;
            boolean b = check(n, quantities, mid);
            if (b) {
                min = Math.min(min, mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return min;
    }

    // Will return false if we are unable to distribute all items
    boolean check(
        int n, int[] arr,
        int x
    ) {
        if (x == 0) {
            return false;
        }

        int i = 0, j = 0;
        for (; i < arr.length && j < n; i++) {
            int count = arr[i] % x == 0 ? arr[i]/x : arr[i]/x + 1;
            j += count;
        }

        return j <= n && i == arr.length;
    }
}