// https://leetcode.com/problems/total-cost-to-hire-k-workers
class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> top = new PriorityQueue<>();
        PriorityQueue<Integer> bottom = new PriorityQueue<>();
        long cost = 0;
        int l = 0, r = costs.length - 1;

        for (int x = 0; x < candidates; x++, l++) {
            top.add(costs[l]);
        }

        for (int x = 0; x < candidates; x++, r--) {
            if (l >= r) {
                break;
            }

            bottom.add(costs[r]);
        }

        for (int x = 0; x < k; x++) {
            if (top.isEmpty() && bottom.isEmpty()) break;
            int f = top.isEmpty() ? Integer.MAX_VALUE : top.peek();
            int s = bottom.isEmpty() ? Integer.MAX_VALUE : bottom.peek();

            if (f <= s) {
                cost += f;
                top.poll();
                if (l <= r) {
                    top.add(costs[l++]);
                }
            } else {
                cost += s;
                bottom.poll();
                if (r >= l) {
                    bottom.add(costs[r--]);
                }
            }
        }

        return cost;
    }
}