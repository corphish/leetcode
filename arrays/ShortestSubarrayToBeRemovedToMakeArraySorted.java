// https://leetcode.com/problems/shortest-subarray-to-be-removed-to-make-array-sorted
class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int left = 0, right = arr.length - 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] >= arr[i - 1]) {
                left = i;
            } else {
                break;
            }
        }

        if (left == arr.length - 1) {
            return 0;
        }

        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] <= arr[i + 1]) {
                right = i;
            } else {
                break;
            }
        }

        if (left == 0 && right == arr.length - 1) {
            if (arr[0] <= arr[arr.length - 1]) {
                return arr.length - 2;
            } else {
                return arr.length - 1;
            }
        }

        int min = Math.min(right, arr.length - 1 - left);

        for (int i = 0; i <= left; i++) {
            // We will binary search arr[i] in the right side
            int ix = Arrays.binarySearch(arr, right, arr.length, arr[i]);
            if (ix >= right) {
                for (; ix > i && arr[ix] == arr[i]; ix--);
                ix += 1;
            } else {
                ix = -ix - 1;
            }

            min = Math.min(min, ix - i - 1);
        }

        return min;
    }
}