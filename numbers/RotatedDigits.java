// https://leetcode.com/problems/rotated-digits
class Solution {
    public int rotatedDigits(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int rotated = rotate(i);
            if (rotated > 0 && rotated != i) {
                count++;
            }
        }
        
        return count;
    }
    
    int rotate(int n) {
        String x = "" + n;
        if (x.contains("3") || x.contains("4") || x.contains("7")) {
            return -1;
        }
        
        return Integer.parseInt(
            x.replace("2", "x")
             .replace("5", "2")
             .replace("x", "5")
             .replace("6", "x")
             .replace("9", "6")
             .replace("x", "9")
        );
    }
}