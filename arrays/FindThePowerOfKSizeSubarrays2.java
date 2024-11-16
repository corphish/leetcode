// https://leetcode.com/problems/find-the-power-of-k-size-subarrays-ii
class Solution {
    public int[] resultsArray(int[] arr, int k) {
        int[] res = new int[arr.length - k + 1];

        if (k == 1) {
            for (int i = 0; i < arr.length; i++) {
                res[i] = arr[i];
            }

            return res;
        }

        int curr = 1, j = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1] + 1) {
                curr += 1;
            } else {
                curr = 1;
            }

            if (i >= k - 1) {
                if (curr >= k && arr[i] - arr[i - k + 1] == k - 1) {
                    res[j++] = arr[i];
                } else {
                    res[j++] = -1;
                }
            }
        }

        return res;
    }
}