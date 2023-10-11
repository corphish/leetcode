// https://leetcode.com/problems/champagne-tower
class Solution {
    final int rows = 100;
    final int cols = 100;
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] glasses = new double[rows][2 * cols + 1];
        glasses[0][cols] = poured;
        for (int i = 0; i < rows; i++) {
            boolean shouldCheckNext = false;
            for (int j = 0; j < glasses[i].length; j++) {
                if (glasses[i][j] > 1) {
                    double rem = glasses[i][j] - 1;
                    glasses[i][j] = 1;
                    if (i + 1 < rows) {
                        if (j - 1 >= 0) {
                            glasses[i + 1][j - 1] += rem/2;
                            shouldCheckNext = true;
                        }

                        if (j + 1 < glasses[i].length) {
                            glasses[i + 1][j + 1] += rem/2;
                            shouldCheckNext = true;
                        }
                    }
                }
            }

            if (!shouldCheckNext) {
                break;
            }
        }

        return glasses[query_row][cols - query_row + 2 * query_glass];
    }
}