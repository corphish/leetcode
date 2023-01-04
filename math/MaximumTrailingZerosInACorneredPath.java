// https://leetcode.com/problems/maximum-trailing-zeros-in-a-cornered-path/
class Solution {
    public int maxTrailingZeros(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        TZero[][] hor = new TZero[m][n];
        TZero[][] ver = new TZero[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                TZero t;
                if (j == 0) {
                    t = new TZero();
                } else {
                    t = hor[i][j - 1].mutate();
                }

                hor[i][j] = t.consider(grid[i][j]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                TZero t;
                if (j == 0) {
                    t = new TZero();
                } else {
                    t = ver[j - 1][i].mutate();
                }

                ver[j][i] = t.consider(grid[j][i]);
            }
        }

        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                TZero t;

                // Top Left
                t = hor[i][j].combineWith(i == 0 ? TZero.ONE : ver[i - 1][j]);
                max = Math.max(max, t.trailingZeros());

                // Top Right
                t = ver[i][j].combineWith(hor[i][n - 1].extractFrom(hor[i][j]));
                max = Math.max(max, t.trailingZeros());

                // Bottom left
                t = hor[i][j].combineWith(ver[m - 1][j].extractFrom(ver[i][j]));
                max = Math.max(max, t.trailingZeros());

                // Bottom right
                t = ver[m - 1][j].extractFrom(i == 0 ? TZero.ONE : ver[i - 1][j])
                            .combineWith(hor[i][n - 1].extractFrom(hor[i][j]));
                max = Math.max(max, t.trailingZeros());
            }
        }

        return max;
    }

    static class TZero {
        int twos, fives;

        private TZero(int twos, int fives) {
            if (twos < 0 || fives < 0) {
                throw new IllegalArgumentException("Factor counts cannot be negative");
            }
            this.twos = twos;
            this.fives = fives;
        }

        TZero() {}

        TZero consider(int x) {
            while (x % 5 == 0) {
                fives++;
                x /= 5;
            }

            while (x % 2 == 0) {
                twos++;
                x /= 2;
            }

            return this;
        }

        TZero mutate() {
            return new TZero(twos, fives);
        }

        int trailingZeros() {
            return Math.min(twos, fives);
        }

        TZero extractFrom(TZero from) {
            return new TZero(this.twos - from.twos, this.fives - from.fives);
        }

        TZero combineWith(TZero other) {
            return new TZero(this.twos + other.twos, this.fives + other.fives);
        }

        public String toString() {
            return "(" + twos + ", " + fives + ")";
        }

        static TZero ONE = new TZero(0, 0);
    }
}