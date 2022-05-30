// https://leetcode.com/problems/find-subsequence-of-length-k-with-the-largest-sum
class Solution {
    // Build a priority queue from the array.
    // Remove elements until the queue size is k.
    // To create the result, iterate the array and try removing an element from the queue.
    // If the element got removed, add it in res array order.
    public int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        
        for (int x: nums) {
            queue.add(x);
        }
        
        while (queue.size() != k) queue.poll();
        
        int[] res = new int[k];
        int i = 0;
        for (int x: nums) {
            if (queue.remove(x)) {
                res[i++] = x;
            }
        }
        
        return res;
    }
}