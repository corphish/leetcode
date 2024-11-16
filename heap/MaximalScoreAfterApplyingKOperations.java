// https://leetcode.com/problems/maximal-score-after-applying-k-operations
class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        long res = 0;

        for (int x: nums) {
            queue.add(x);
        }

        while (k-- > 0) {
            int x = queue.poll();
            res += x;
            x = x % 3 == 0 ? x/3 : x/3 + 1;
            queue.add(x);
        }

        return res;
    }
}