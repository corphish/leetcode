// https://leetcode.com/problems/lucky-numbers-in-a-matrix/
class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        Set<Integer> min = new HashSet<>();
        List<Integer> res = new ArrayList<>();

        for (int row[]: matrix) {
            int rowMin = Integer.MAX_VALUE;
            for (int x: row) {
                rowMin = Math.min(x, rowMin);
            }

            min.add(rowMin);
        }

        for (int i = 0; i < matrix[0].length; i++) {
            int max = 0;
            for (int j = 0; j < matrix.length; j++) {
                max = Math.max(max, matrix[j][i]);
            }

            if (min.contains(max)) {
                res.add(max);
            }
        }

        return res;
    }
}