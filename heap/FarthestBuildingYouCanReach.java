// https://leetcode.com/problems/furthest-building-you-can-reach
class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        int b = 0;

        for (int i = 1; i < heights.length; i++) {
            if (heights[i] > heights[i - 1]) {
                int diff = heights[i] - heights[i - 1];
                if (q.size() == ladders) {
                    if (ladders != 0 && q.peek() < diff) {
                        b += q.poll();
                        q.add(diff);
                    } else {
                        b += diff;
                    }
                } else {
                    q.add(diff);
                }
            }

            if (b > bricks) {
                return i - 1;
            }
        }

        return heights.length - 1;
    }
}