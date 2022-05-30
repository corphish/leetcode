// https://leetcode.com/problems/largest-number-after-digit-swaps-by-parity
class Solution {
    // Have 2 priority queues - One to store odd numbers and one to store evens.
    // Have a parity array that stores the parity of digits in reverse order
    // Now poll from each queue depending on parity and put them at last
    public int largestInteger(int num) {
        PriorityQueue<Integer> oddQueue = new PriorityQueue<>();
        PriorityQueue<Integer> evenQueue = new PriorityQueue<>();
        int[] parity = new int[10];
        Arrays.fill(parity, -1);
        
        int i = 0;
        while (num > 0) {
            int r = num % 10;
            parity[i++] = r % 2;
            if (r % 2 == 1) {
                oddQueue.add(r);
            } else {
                evenQueue.add(r);
            }
            
            num /= 10;
        }
        
        int res = 0, t = 1;
        for (int x: parity) {
            if (x == -1) break;
            if (x == 0) res = evenQueue.poll() * t + res;
            else res = oddQueue.poll() * t + res;
            
            t *= 10;
        }
        
        return res;
    }
}