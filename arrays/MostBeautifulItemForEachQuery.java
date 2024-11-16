// https://leetcode.com/problems/most-beautiful-item-for-each-query/
class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int[][] p = new int[items.length][2];
        int max = -1;

        for (int i = 0; i < items.length; i++) {
            max = Math.max(max, items[i][1]);
            p[i][0] = items[i][0];
            p[i][1] = max;
        }

        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int ix = binarySearch(p, queries[i]);
            if (ix >= 0) {
                res[i] = p[ix][1];
            } else {
                ix = -ix - 1;
                if (ix == 0) {
                    res[i] = 0;
                } else {
                    res[i] = p[ix - 1][1];
                }
            }
        }

        return res;
    }

    int binarySearch(
        int[][] p,
        int q
    ) {
        int low = 0, high = p.length - 1, mid = 0;

        while (low <= high) {
            mid = (low + high)/2;
            if (p[mid][0] == q) {
                return mid;
            } else if (p[mid][0] > q) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -(low + 1);
    }
}