// https://leetcode.com/problems/remove-covered-intervals/
class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int count = 0;
        boolean[] isRemoved = new boolean[intervals.length];
        
        for (int i = 0; i < intervals.length; i++) {
            if (isRemoved[i]) continue;
            for (int j = 0; j < intervals.length; j++) {
                if (i != j) {
                    if (intervals[j][0] <= intervals[i][0] && intervals[j][1] >= intervals[i][1]) {
                        count++;
                        isRemoved[i] = true;
                        break;
                    }
                }
            }
        }
        
        return intervals.length - count;
    }
}