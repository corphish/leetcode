// https://leetcode.com/problems/average-salary-excluding-the-minimum-and-maximum-salary
class Solution {
    public double average(int[] salary) {
        int min = Integer.MAX_VALUE, max = 0, sum = 0;
        for (int x: salary) {
            if (x < min) {
                min = x;
            }
            
            if (x > max) {
                max = x;
            }
            
            sum += x;
        }
        
        return (sum - max - min)/(salary.length - 2.0);
    }
}