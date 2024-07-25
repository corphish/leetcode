// https://leetcode.com/problems/alternating-groups-i/
class Solution {
    public int numberOfAlternatingGroups(int[] colors) {
        return count(colors, 3);
    }

    public int count(int[] colors, int k) {
        int l = 0, count = 0;
        int[] circ = new int[colors.length + k - 1];

        for (int i = 0; i < circ.length; i++) {
            if (i >= colors.length) {
                circ[i] = colors[i % colors.length];
            } else {
                circ[i] = colors[i];
            }
        }

        for (int i = 1; i < circ.length; i++) {
            if (circ[i] == circ[i - 1]) {
                l = i;
            }

            if (i - l == k - 1) {
                count += 1;
                l += 1;
            }
        }

        return count;
    }
}