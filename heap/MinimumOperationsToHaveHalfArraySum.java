// https://leetcode.com/problems/minimum-operations-to-halve-array-sum
class Solution {
    // We will reduce the current greatest element in the array to its half in each move and track the sum.
    // We will stop when the sum is less than or equal to original sum.
    public int halveArray(int[] nums) {
        double sum = 0;
        PriorityQueue<Double> queue = new PriorityQueue<>(1, Collections.reverseOrder());
        
        for (int x: nums) {
            double val = (double) x;
            sum += val;
            queue.add(val);
        }
        
        int moves = 0;
        double currentSum = sum;
        while (currentSum > sum/2) {
            //System.out.println("Sum = " + sum + ", current = " + currentSum);
            double max = queue.poll();
            currentSum -= max;
            max = max/2;
            currentSum += max;
            queue.add(max);
            moves++;
        }
        
        return moves;
    }
}