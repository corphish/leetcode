// https://leetcode.com/problems/valid-square
class Solution {
    // For each point, we check the distance to the other 3 whether, 2 of them should be equal and the other one  should be sum of the other 2 squared
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) { 
        return check(p1, p2, p3, p4) && check(p2, p1, p3, p4) && check(p3, p2, p1, p4) && check(p4, p2, p3, p1);
    }
    
    public boolean check(int[] p1, int[] p2, int[] p3, int[] p4) {        
        // p1 to all
        int a = sqDistance(p1, p2);
        int b = sqDistance(p1, p3);
        int c = sqDistance(p1, p4);
        
        int[] arr = {a, b, c};
        Arrays.sort(arr);
        
        return arr[0] + arr[1] == arr[2] && arr[0] == arr[1] && arr[2] != 0;
    }
    
    int sqDistance(int[] p1, int[] p2) {
        int x = p2[0] - p1[0];
        int y = p2[1] - p1[1];
        
        return x * x + y * y;
    }
}