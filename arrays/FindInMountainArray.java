/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 * public int get(int index) {}
 * public int length() {}
 * }
 */
// https://leetcode.com/problems/find-in-mountain-array/submissions/1146749102/
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int length = mountainArr.length();
        int pivot = -1;

        // Find the pivot
        int l = 0, r = length;
        while (l <= r) {
            pivot = (l + r) / 2;

            int lv = mountainArr.get(pivot - 1);
            int v = mountainArr.get(pivot);
            int rv = mountainArr.get(pivot + 1);

            if (lv < v && rv < v) {
                break;
            }

            if (lv < v && v < rv) {
                l = pivot;
            } else {
                r = pivot;
            }
        }

        if (mountainArr.get(pivot) == target) {
            return pivot;
        }

        int lSearch = binarySearch(mountainArr, target, 0, pivot - 1, 0);
        int rSearch = binarySearch(mountainArr, target, pivot + 1, length - 1, 1);
        return lSearch == -1 && rSearch == -1 ? -1 : lSearch == -1 ? rSearch : lSearch;
    }

    int binarySearch(MountainArray arr, int target, int l, int r, int dir) {
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int v = arr.get(mid);
            if (v == target) {
                return mid;
            }

            if (v < target) {
                if (dir == 0)
                    l = mid + 1;
                else
                    r = mid - 1;
            } else {
                if (dir == 1)
                    l = mid + 1;
                else
                    r = mid - 1;
            }
        }

        return -1;
    }
}