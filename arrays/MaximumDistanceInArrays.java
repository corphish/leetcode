// https://leetcode.com/problems/maximum-distance-in-arrays
class Solution {
    final int BOUND = 100000;
    public int maxDistance(List<List<Integer>> arrays) {
        int[][] min = new int[2][2];
        int[][] max = new int[2][2];

        min[0][0] = BOUND;
        min[1][0] = BOUND;

        max[0][0] = -BOUND;
        max[1][0] = -BOUND;

        for (int i = 0; i < arrays.size(); i++) {
            var list = arrays.get(i);
            int first = list.get(0);
            int last = list.get(list.size() - 1);

            if (first < min[0][0]) {
                min[1][0] = min[0][0];
                min[1][1] = min[0][1];
                min[0][0] = first;
                min[0][1] = i;
            } else if (first < min[1][0]) {
                min[1][0] = first;
                min[1][1] = i;
            }

            if (last > max[0][0]) {
                max[1][0] = max[0][0];
                max[1][1] = max[0][1];
                max[0][0] = last;
                max[0][1] = i;
            } else if (last > max[1][0]) {
                max[1][0] = last;
                max[1][1] = i;
            }
        }

        return min[0][1] != max[0][1] ? max[0][0] - min[0][0] : Math.max(max[0][0] - min[1][0], max[1][0] - min[0][0]);
    }
}