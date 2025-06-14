// https://leetcode.com/problems/minimum-operations-to-exceed-threshold-value-ii/
class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> q = new PriorityQueue<>();

        for (int x: nums) {
            q.add(x * 1L);
        }

        int count = 0;

        while (q.peek() < k) {
            long x = q.poll();
            long y = q.poll();

            count += 1;

            q.add(2 * x + y);
        }

        return count;
    }
}