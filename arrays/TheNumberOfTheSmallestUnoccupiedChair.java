// https://leetcode.com/problems/the-number-of-the-smallest-unoccupied-chair
class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int n = times.length;
        int[][] occ  = new int[n][2]; // occ[i][0] -> occupied by, occ[i][1] -> occupied till

        int[][] arr = new int[n][3];

        for (int i = 0; i < n; i++) {
            arr[i][0] = times[i][0];
            arr[i][1] = times[i][1];
            arr[i][2] = i;
        }

        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        for (int i = 0; i < n; i++) {
            int selected = -1;
            for (int j = 0; j < n; j++) {
                if (occ[j][1] == 0 || arr[i][0] >= occ[j][1]) {
                    selected = j;
                    occ[j][0] = arr[i][2];
                    occ[j][1] = arr[i][1];
                    break;
                }
            }

            if (arr[i][2] == targetFriend) {
                return selected;
            }
        }

        return -1;
    }
}