// https://leetcode.com/problems/beautiful-arrangement/
class Solution {
    public int countArrangement(int n) {
        int[] arr = new int[n];
        return gen(arr, 1);
    }

    int gen(int[] arr, int x) {
        if (x > arr.length) {
            for (int y: arr) {
                if (y == 0) return 0;
            }

            return 1;
        }

        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0 && (x % (i + 1) == 0 || (i + 1) % x == 0)) {
                arr[i] = x;
                count += gen(arr, x + 1);
                arr[i] = 0;
            }
        }

        return count;
    }
}