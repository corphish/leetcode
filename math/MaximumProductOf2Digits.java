// https://leetcode.com/problems/maximum-product-of-two-digits/
class Solution {
    public int maxProduct(int n) {
        int a = 0, b = 0;
        while (n > 0) {
            int r = n % 10;
            if (r > a) {
                b = a;
                a = r;
            } else if (r > b) {
                b = r;
            }

            n /= 10;
        }

        return a * b;
    }
}