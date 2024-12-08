// https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k
class Solution {
    public long maximumSubarraySum(int[] arr, int k) {
        int m = 0;
        for (int x: arr) m = x > m ? x : m;
        long max = 0, sum = 0;
        int[] freq = new int[m + 1];
        int multi = 0, l = 0;

        for (int i = 0; i < k; i++) {
            sum += arr[i];
            freq[arr[i]] += 1;
            if (freq[arr[i]] == 2) {
                multi += 1;
            }
        }

        if (multi == 0) {
            max = sum;
        }

        for (int i = k; i < arr.length; i++) {
            sum -= arr[l];
            sum += arr[i];

            freq[arr[l]] -= 1;
            if (freq[arr[l]] == 1) {
                multi -= 1;
            }

            l += 1;

            freq[arr[i]] += 1;
            if (freq[arr[i]] == 2) {
                multi += 1;
            }

            if (multi == 0) {
                max = Math.max(max, sum);
            }
        }

        return max;
    }
}