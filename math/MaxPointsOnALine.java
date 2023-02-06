// https://leetcode.com/problems/max-points-on-a-line
class Solution {
    public int maxPoints(int[][] points) {
        int max = 1;
        for (int i = 0; i < points.length; i++) {
            Map<Double, Integer> count = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (i != j) {
                    double slope = (points[i][1] * 1.0 - points[j][1])/(points[i][0] * 1.0 - points[j][0]);
                    count.put(slope, count.getOrDefault(slope, 1) + 1);
                }
            }
            
            for (int x: count.values()) max = Math.max(max, x);
        }
        
        return max;
    }
}