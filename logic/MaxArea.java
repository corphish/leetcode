// https://leetcode.com/problems/container-with-most-water
class Solution {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1, area = computeArea(height, l, r), i;
        while (l < r) {
            if (height[l] <= height[r]) {
                for (i = l; i < r && height[i] <= height[l]; i++);
                l = i;
            } else {
                for (i = r; i > l && height[i] <= height[r]; i--);
                r = i;
            }
            
            area = Math.max(area, computeArea(height, l, r));
        }
        
        return area;
    }
    
    private int computeArea(int[] height, int l, int r) {
        //System.out.println(l + ", " + r);
        return (r - l) * Math.min(height[l], height[r]);
    }
}