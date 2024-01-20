// https://leetcode.com/problems/sum-of-subarray-minimums
class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        long sum = 0, mod = 1000000007;
        for (int i = 0; i < n; i++) {
            int left = i - 1, right = i + 1;

            for (; left >= 0 && arr[left] > arr[i]; left--)
                ;
            for (; right < n && arr[right] >= arr[i]; right++)
                ;

            left += 1;
            right -= 1;

            int count = right - left + 1;
            int iAdj = i - left;

            // N * (i + 1) - i * (i + 1)
            long inc = count * (iAdj + 1) - iAdj * (iAdj + 1);
            sum += inc * arr[i];
            sum %= mod;
        }

        return (int) sum;
    }
}