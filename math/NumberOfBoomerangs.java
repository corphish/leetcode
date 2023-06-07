// https://leetcode.com/problems/number-of-boomerangs
class Solution {
    public int numberOfBoomerangs(int[][] points) {
        Map<Integer, Map<Double, Integer>> map = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            int[] x = points[i];
            for (int j = 0; j < points.length; j++) {
                int[] y = points[j];
                if (i != j) {
                    double dist = dist(x, y);
                    if (map.get(i) == null) {
                        map.put(i, new HashMap<>());
                    }

                    Map<Double, Integer> subMap = map.get(i);
                    subMap.put(dist, subMap.getOrDefault(dist, 0) + 1);
                }
            }
        }

        int count = 0;

        for (int i = 0; i < points.length; i++) {
            Map<Double, Integer> subMap = map.get(i);
            if (subMap == null) continue;
            for (int x: subMap.values()) {
                count += x * (x - 1);
            }
        }

        return count;
    }

    double dist(int[] a, int[] b) {
        return Math.sqrt(
            (b[0] - a[0]) * (b[0] - a[0]) + (b[1] - a[1]) * (b[1] - a[1])
        );
    }
}