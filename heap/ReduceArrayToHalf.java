// https://leetcode.com/problems/reduce-array-size-to-the-half
class Solution {
    // 1. First build a map storing frequencies of each element in array.
    // 2. Build a priority queue out of these frequencies (max heap).
    // 3. Keep on removing the top element from the queue (this top element is the size), and subtract the value from the current length.
    // 4. If the current length is less than n/2, stop and return the number of operations.
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();
        int n = arr.length;
        
        for (int x: arr) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }
        
        PriorityQueue<Integer> queue = new PriorityQueue<>(1, Collections.reverseOrder());
        for (int x: freq.values()) {
            queue.add(x);
        }
        
        int curLen = n;
        int removals = 0;
        
        while (curLen > n/2) {
            int size = queue.poll();
            curLen -= size;
            removals++;
        }
        
        return removals;
    }
}