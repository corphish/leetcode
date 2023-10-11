// https://leetcode.com/problems/count-all-valid-pickup-and-delivery-options
class Solution {
    public int countOrders(int n) {
        return (int) ((factorial(n) * oddProduct(n)) % 1000000007);
    }
    
    public long factorial(int n) {
        long p = 1;
        for (int i = 2; i <= n; i++) {
            p = (p * i) % 1000000007;
        }
        
        return p;
    }
    
    public long oddProduct(int n) {
        long p = 1, k = 3;
        for (int i = 2; i <= n; i++, k += 2) {
            p = (p * k) % 1000000007;
        }
        
        return p;
    }
}