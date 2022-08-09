class Solution {
    public int divide(int dividend, int divisor) {
        int quotient = 0;
        int negativity = 1;
        
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
            negativity = -1;
        }
        
        if (divisor == -1 && dividend == Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }
        
        if (divisor == 1) {
            return dividend;
        }
        
        if (divisor == -1) {
            return -dividend;
        }
        
        if (divisor == Integer.MIN_VALUE) {
            return dividend == divisor ? 1 : 0;
        }
        
        boolean isMin = false;
        
        if (dividend != Integer.MIN_VALUE) {
            dividend = dividend < 0 ? -dividend : dividend;
        } else {
            dividend = Integer.MAX_VALUE;
            quotient = 0;
            isMin = true;
        }
        
        divisor = divisor < 0 ? -divisor : divisor;
        
        if (dividend < divisor) {
            return 0;
        }
        
        while (dividend >= divisor) {
            dividend -= divisor;
            quotient++;
        }
        
        return quotient * negativity + (isMin ? dividend == divisor - 1 ? negativity : 0 : 0);
    }
}