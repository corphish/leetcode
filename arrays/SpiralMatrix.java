class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int t = 1, b = 0, l = 0, r = 0;
        int x = 0, y = 0, lx = -1, ly = -1, d = 0; // 0 -right, 1 - down, 2 - left, 3 - up

        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < m * n; ) {
            if (x != lx || y != ly) {
                res.add(matrix[x][y]);      
                i++;
            }

            lx = x;
            ly = y;            

            if (d == 0) {
                y++;
                if (y >= m - r) {
                    d = 1;
                    r += 1;
                    y -= 1;
                }
            }

            if (d == 1) {
                x++;
                if (x >= n - b) {
                    d = 2;
                    b += 1;
                    x -= 1;
                }
            }

            if (d == 2) {
                y--;
                if (y < l) {
                    d = 3;
                    l += 1;
                    y += 1;
                }
            }

            if (d == 3) {
                x--;
                if (x < t) {
                    d = 0;
                    t += 1;
                    x += 1;
                }
            }
        }

        return res;
    }
}