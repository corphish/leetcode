// https://leetcode.com/problems/maximize-the-total-height-of-unique-towers
class Solution {
    public long maximumTotalSum(int[] arr) {
        Arrays.sort(arr);
        long res = arr[arr.length - 1];

        for (int i = arr.length - 2; i >= 0; i--) {
            arr[i] = Math.min(arr[i], arr[i + 1] - 1);
            if (arr[i] == 0) {
                return -1;
            }

            res += arr[i];
        }

        return res;
    }
}