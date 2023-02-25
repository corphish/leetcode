// https://leetcode.com/problems/add-to-array-form-of-integer
class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> res = new ArrayList<>();
        int carry = 0;
        for (int i = num.length - 1; i >= 0; i--, k /= 10) {
            int r = k % 10;
            num[i] += r + carry;
            carry = num[i]/10;
            num[i] = num[i] % 10;
        }

        carry += k;
        while (carry != 0) {
            res.add(0, carry % 10);
            carry /= 10;
        }

        for (int i = 0; i < num.length; i++) {
            res.add(num[i]);
        }

        return res;
    }
}