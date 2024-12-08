// https://leetcode.com/problems/defuse-the-bomb
class Solution {
    public int[] decrypt(int[] code, int k) {
        if (k == 0) {
            Arrays.fill(code, 0);
            return code;
        }

        int[] arr = new int[3 * code.length];

        for (int i = 0; i < code.length; i++) {
            arr[i] = arr[code.length + i] = arr[2 * code.length + i] = code[i];
        }

        int l = k > 0 ? code.length + 1 : 2 * code.length + k;
        int r = k > 0 ? code.length + k : 2 * code.length - 1;

        int sum = 0;
        for (int i = l; i <= r; i++) {
            sum += arr[i];
        }

        for (int i = 0; i < code.length; i++) {
            code[i] = sum;
            sum -= arr[l];
            l += 1;
            r += 1;
            sum += arr[r];
        }

        return code;
    }
}