// https://leetcode.com/problems/minimize-xor
class Solution {
    public int minimizeXor(int num1, int num2) {
        int b = Integer.bitCount(num2), r = 0;
        int[] x = bitsOf(num1);
        int[] res = bitsOf(0);

        // Use up all the bit count from MSB to LSB
        for (int i = 0; i < 32 && b > 0; i++) {
            if (x[i] == 1) {
                res[i] = 1;
                b -= 1;
            }
        }

        // Fill from LSB
        for (int i = 31, k = 0; i >= 0; i -= 1, k++) {
            if (b > 0 && x[i] == 0) {
                res[i] = 1;
                b -= 1;
            }
            
            r += res[i] * (1 << k);
        }

        return r;
    }

    int[] bitsOf(int x) {
        int[] res = new int[32];
        int k = 31;

        while (x > 0) {
            res[k--] = x & 1;
            x >>= 1;
        }

        return res;
    }
}