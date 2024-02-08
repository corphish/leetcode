// https://leetcode.com/problems/perfect-squares
class Solution {
    private Map<Integer, Integer> s = new HashMap<>();
    public int numSquares(int n) {
        if (n < 4) return n;
        if (n < 8) return n - 3;
        if (s.get(n) != null) return s.get(n);
        
        int sqrt = (int) (Math.sqrt(n));
        if (sqrt * sqrt == n) {
            return 1;
        }
        
        int min = Integer.MAX_VALUE;
        for (int i = sqrt; i > 0; i--) {
            int x = 1 + numSquares(n - (i * i));
            min = Math.min(min, x);
        }
        
        s.put(n, min);
        return min;
    }
}