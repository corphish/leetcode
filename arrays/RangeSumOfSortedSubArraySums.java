// https://leetcode.com/problems/range-sum-of-sorted-subarray-sums
class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int[] list = new int[n * (n + 1)/2];
        int k = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                list[k++] = sum;
            }
        }

        Arrays.sort(list);
        long res = 0;
        for (int i = left - 1; i < right; i++) {
            res += list[i];
        }

        return (int) (res % 1000000007);
    }
}