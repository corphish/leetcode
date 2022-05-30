// https://leetcode.com/problems/check-if-it-is-a-straight-line
class Solution {
    public boolean checkStraightLine(int[][] p) {
        var formula = Formula.of(p[0], p[1]);
        boolean res = true;
        
        for (int i = 2; i < p.length; i++) {
            res = res && formula.test(p[i]);
        }
        
        return res;
    }
    
    static class Formula {
        double m, y2, x2;
        
        static Formula of(int[] p1, int[] p2) {
            return new Formula(
                (p2[1] * 1.0 - p1[1])/(p2[0] - p1[0]),
                p2[1],
                p2[0]
            );
        }
        
        private Formula(double m, double y2, double x2) {
            this.y2 = y2;
            this.x2 = x2;
            this.m = m;
            System.out.println(m);
        }
        
        boolean test(int[] p) {
            return m == Double.POSITIVE_INFINITY || m == Double.NEGATIVE_INFINITY ? p[0] == x2 : p[1] - y2 == m * (p[0] - x2);
        }
    }
}