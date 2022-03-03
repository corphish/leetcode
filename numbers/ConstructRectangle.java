// https://leetcode.com/problems/construct-the-rectangle
class Solution {
    public int[] constructRectangle(int area) {
        int k = 1;
        for (int i = 1; i * i <= area; i++) {
            if (area % i == 0) {
                k = i;
            }
        }
        
        return new int[] {area/k, k};
    }
}