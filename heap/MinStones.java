// https://leetcode.com/problems/remove-stones-to-minimize-the-total
class Solution {
    // Build a priorityQueue for the input array
    // For each iteration (performed k number of times), get the current max in the queue
    // Remove floor(val/2) from it and add back to array.
    // After k moves, return the sum of queue.
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(1, Collections.reverseOrder());
        for (int x: piles) queue.add(x);
        
        while (k-- > 0) {
            int x = queue.poll();
            x -= x/2;
            queue.add(x);
        }
        
        int sum = 0;
        for (int x: queue) sum += x;
        
        return sum;
    }
}