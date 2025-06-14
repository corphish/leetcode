// https://leetcode.com/problems/count-largest-group/
class Solution {
    public int countLargestGroup(int n) {
        int[] count = new int[37];
        int max = 0, group = 0;

        for (int i = 1; i <= n; i++) {
            int sum = 0, j = i;
            while (j > 0) {
                sum += j % 10;
                j /= 10;
            }

            count[sum] += 1;
        }

        for (int i = 0; i < 37; i++) {
            if (count[i] == max) {
                group += 1;
            } else if (count[i] > max) {
                max = count[i];
                group = 1;
            }
        }

        return group;
    }
}