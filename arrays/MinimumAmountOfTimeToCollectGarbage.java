// https://leetcode.com/problems/minimum-amount-of-time-to-collect-garbage
class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int[][] count = new int[3][garbage.length];

        int i = 0, sum = 0;
        for (String s: garbage) {
            int metal = 0, glass = 0, paper = 0;
            for (char c: s.toCharArray()) {
                if (c == 'G') {
                    glass += 1;
                } else if (c == 'P') {
                    paper += 1;
                } else {
                    metal += 1;
                }
            }

            count[0][i] = glass;
            count[1][i] = paper;
            count[2][i] = metal;

            i += 1;
        }

        for (i = 0; i < count.length; i++) {
            int lastPickup = 0;
            for (int j = 0; j < garbage.length; j++) {
                if (count[i][j] > 0) {
                    sum += lastPickup + count[i][j];
                    lastPickup = 0;
                }

                lastPickup += j < travel.length ? travel[j] : 0;
            }
        }

        return sum;
    }
}