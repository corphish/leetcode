// https://leetcode.com/problems/minimum-cost-to-reach-every-position/
class Solution {
    public int[] minCosts(int[] cost) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < cost.length; i++) {
            cost[i] = min = Math.min(min, cost[i]);
        }

        return cost;
    }
}