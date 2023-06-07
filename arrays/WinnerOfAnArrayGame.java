// https://leetcode.com/problems/find-the-winner-of-an-array-game
class Solution {
    public int getWinner(int[] arr, int k) {
        int last = 0, lastCount = 0;

        // Instead of moving the loser to last, we swap the loser to earlier position of the 2 contenstants
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                if (last == arr[i - 1]) {
                    lastCount += 1;
                } else {
                    last = arr[i - 1];
                    lastCount = 1;
                }

                // Swap
                int t = arr[i - 1];
                arr[i - 1] = arr[i];
                arr[i] = t;
            } else {
                if (last == arr[i]) {
                    lastCount += 1;
                } else {
                    last = arr[i];
                    lastCount = 1;
                }
            }

            if (lastCount == k) {
                break;
            }
        }

        return last;
    }
}