// https://leetcode.com/problems/rings-and-rods
class Solution {
    public int countPoints(String rings) {
        int[][] store = new int[10][3];
        
        for (int i = 0; i < rings.length() - 1; i += 2) {
            char color = rings.charAt(i);
            int rod = rings.charAt(i + 1) - 48;
            
            store[rod][color == 'R' ? 0 : color == 'G' ? 1 : 2]++;
        }
        
        int count = 0;
        for (int i = 0; i < 10; i++) {
            int p = 1;
            for (int j = 0; j < 3; j++) {
                p *= store[i][j];
            }
            
            if (p > 0) count++;
        }
        
        return count;
    }
}