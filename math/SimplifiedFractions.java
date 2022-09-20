// https://leetcode.com/problems/simplified-fractions/
class Solution {
    public List<String> simplifiedFractions(int n) {
        List<String> res = new ArrayList<>();
        
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i < j && gcd(i, j) == 1) {
                    res.add(i + "/" + j);
                }
            }
        }
        
        return res;
    }
    
    int gcd(int a, int b) {
        return a % b == 0 ? b : gcd(b, a % b);
    }
}