// https://leetcode.com/problems/minimum-cost-to-make-array-equal
class Solution {
    public long minCost(int[] nums, int[] cost) {
        int n = nums.length;
        long count = 0, min = Long.MAX_VALUE;
        int[][] group = new int[n][2];

        for (int i = 0; i < n; i++) {
            group[i][0] = nums[i];
            group[i][1] = cost[i];
            count += cost[i];
        }

        Arrays.sort(group, (a, b) -> a[0] - b[0]);
        int[] medians = median(group, count);
        for (int x: medians) {
            long t = 0;
            for (int[] g: group) {
                t += 1L * Math.abs(g[0] - x) * g[1];
            }

            min = Math.min(min, t);
        }

        return min;
    }

    int[] median(int[][] group, long count) {
        long cf = 0;
        for (int i = 0; i < group.length; i++) {
            cf += group[i][1];
            if (cf >= count/2) {
                if (count % 2 == 1) {
                    if (cf == count/2) return new int[] { group[i + 1][0] };
                    else return new int[] { group[i][0] };
                } else {
                    if (cf == count/2) return new int[] { group[i][0], group[i + 1][0] };
                    else return new int[] { group[i][0] };
                }
            }
        }

        return new int[] {};
    }
}