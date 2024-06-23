// https://leetcode.com/problems/grumpy-bookstore-owner
class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;

        int[] start = new int[n];
        int[] end = new int[n];

        int max = 0;
        int l = -1, r = minutes;
        int window = 0;

        for (int i = 0, j = n - 1; i < n; i++, j--) {
            if (i == 0) {
                if (grumpy[i] == 0) {
                    end[i] = customers[i];
                }
            } else {
                if (grumpy[i] == 0) {
                    end[i] = end[i - 1] + customers[i];
                } else {
                    end[i] = end[i - 1];
                }
            }

            if (j == n - 1) {
                if (grumpy[j] == 0) {
                    start[j] = customers[j];
                }
            } else {
                if (grumpy[j] == 0) {
                    start[j] = start[j + 1] + customers[j];
                } else {
                    start[j] = start[j + 1];
                }
            }

            if (i < minutes) {
                window += customers[i];
            }
        }

        while (r <= n) {
            int sum = window;
            if (l >= 0) {
                sum += end[l];
            }

            if (r < n) {
                sum += start[r];
            }

            max = Math.max(max, sum);

            if (r == n) {
                break;
            }
            
            l += 1;

            window -= customers[l];
            window += customers[r];

            r += 1;
        }

        return max;
    }
}