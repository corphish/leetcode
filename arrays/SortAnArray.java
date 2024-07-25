// https://leetcode.com/problems/sort-an-array
class Solution {
    public int[] sortArray(int[] arr) {
        _mergeSort(arr, 0, arr.length - 1);
        return arr;
    }

    private void _mergeSort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;

            _mergeSort(arr, low, mid);
            _mergeSort(arr, mid + 1, high);

            _merge(arr, low, mid, high);
        }
    }

    private void _merge(int[] arr, int low, int mid, int high) {
        // Looks like we cannot easily merge in place
        int[] temp = new int[high - low + 1];

        int i = low, j = mid + 1, k = 0;

        while (i <= mid && j <= high) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= high) {
            temp[k++] = arr[j++];
        }

        for (i = 0; i < temp.length; i++) {
            arr[low + i] = temp[i];
        }
    }
}