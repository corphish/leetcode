// https://leetcode.com/problems/count-pairs-that-form-a-complete-day-i
class Solution {
    public int countCompleteDayPairs(int[] hours) {
        int[] freq = new int[24];

        for (int x : hours) {
            freq[x % 24] += 1;
        }

        int count = 0;

        for (int x : hours) {
            int k = x % 24;
            int y = (24 - k) % 24;

            if (k == y) {
                count += freq[y] - 1;
            } else {
                count += freq[y];
            }
        }

        return count / 2;
    }
}