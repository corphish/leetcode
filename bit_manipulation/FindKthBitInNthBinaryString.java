// https://leetcode.com/problems/find-kth-bit-in-nth-binary-string
class Solution {
    public char findKthBit(int n, int k) {
        char[] arr = new char[(1 << n) - 1];
        arr[0] = '0';
        int ptr = 1;
        while (n > 1) {
            arr[ptr] = '1';
            for (int i = ptr - 1, j = ptr + 1; i >= 0; i--, j++) {
                arr[j] = arr[i] == '1' ? '0' : '1';
                ptr += 1;
            }

            ptr += 1;
            n -= 1;
        }

        return arr[k - 1];
    }
}