// https://leetcode.com/problems/maximum-product-after-k-increments
class Solution {
    // Logic: We have to increase the shortest element in the array for each steps performed k times.
    public int maximumProduct(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        
        for (int x: nums) queue.add(x);
        
        while (k-- > 0) {
            int x = queue.poll();
            queue.add(x + 1);
        }
        
        long p = 1;
        for (int x: queue) {
            p = (p * x) % 1000000007;
        }
        
        return (int) p;
    }
}