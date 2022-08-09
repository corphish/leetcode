// https://leetcode.com/problems/clumsy-factorial
class Solution {
    // 10 * 9/8 + 7 - 6 * 5/4 + 3 - 2*1
    // = 11 + 7 - 7 + 3 - 2
    // 18 - 10 - 2
    // 8 * 7/6 + 5 - 4 * 3/2 + 1
    // 9 + 5 - 6 + 1
    
    // The result of the multiplication and division needs to be calculated separately.
    public int clumsy(int n) {
        int p = 0;
        for (int i = n; i >= 1; i -= 4) {
            if (i > 4) {
                int res = (i * (i - 1) / (i - 2));
                if (p == 0) p = res;
                else p -= res;
                
                p += i - 3;
                //System.out.println(res + ", " + p);
            } else {
                int buf = 0;
                int res = i == 4 ? (4 * 3 / 2): i == 3 ? 3 * 2/1 : i == 2 ? 2 * 1 : 1;
                buf = i/4;
                //System.out.println(res);
                if (p == 0) p = res;
                else p -= res;
                
                p += buf;
            }
        }
        
        return p;
    }
}