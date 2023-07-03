// https://leetcode.com/problems/find-the-highest-altitude
class Solution {
    public int largestAltitude(int[] gain) {
        int max = 0;
        for (int i = 0; i < gain.length; i++) {
            if (i > 0) gain[i] += gain[i - 1];
            max = Math.max(max, gain[i]);
        }

        return max;
    }
}