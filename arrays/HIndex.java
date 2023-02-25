// https://leetcode.com/problems/h-index/
class Solution {
    public int hIndex(int[] arr) {
        Arrays.sort(arr);
        return hIndex2(arr);
    }

    public int hIndex2(int[] arr) {
        int low = 0, high = arr.length, ans = 0;
        while (low < high) {
            int mid = (low + high)/2;
            int hIndex = arr.length - mid;

            if (hIndex == 0) {
                return 0;
            } else {
                if (arr[arr.length - hIndex] >= hIndex) {
                    if (arr.length - hIndex - 1 < 0) {
                        return hIndex;
                    } else if (arr[arr.length - hIndex - 1] <= hIndex) {
                        // Possible answer
                        ans = hIndex;
                        low = mid + 1;
                    } else {
                        high = mid;
                    }
                } else {
                    low = mid + 1;
                }
            }
        }
        return ans;
    }
}