// https://leetcode.com/problems/number-of-islands
import java.util.*;

public class Islands {

    public static void main(String[] args) {
        char[][] grid = {
            {'1','0','1','1','1'},
            {'1','0','1','0','1'},
            {'1','1','1','0','1'}
        };

        int n = grid.length, m = grid[0].length;
        UnionFind uf = new UnionFind(m * n + 1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int index = i * m + j;
                if (safeAccess(grid, i, j) == '1') {
                    int left = safeAccess(grid, i, j - 1);
                    int right = safeAccess(grid, i, j + 1);
                    int up = safeAccess(grid, i - 1, j);
                    int down = safeAccess(grid, i + 1, j);

                    if (up + down + left + right == 0) {
                        uf.union(index, index);
                    } 
                    if (up == '1') {
                        uf.union(index, index - m);
                    } 
                    if (down == '1') {
                        uf.union(index, index + m);
                    } 
                    if (left == '1') {
                        uf.union(index, index - 1);
                    } 
                    if (right == '1') {
                        uf.union(index, index + 1);
                    }
                } else {
                    uf.union(index, m * n);
                }
            }
        }

        System.out.println(uf.numberOfRoots());
    }

    static char safeAccess(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return 0;
        }
        return grid[i][j];
    }
    
    static class UnionFind {
        int[] root;
        int[] rank;

        public UnionFind(int n) {
            root = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                root[i] = i;
                rank[i] = 1;
            }
        }
        
        public int find(int x) {
            if (root[x] == x) {
                return x;
            }

            return root[x] = find(root[x]);
        }

        public void union(int x, int y) {
            if (x < 0) return;
            if (y < 0) return;

            int rootX = find(x);
            int rootY = find(y);

            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    root[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    root[rootX] = rootY;
                } else {
                    root[rootY] = rootX;
                    rank[rootX] += 1;
                }
            }

            System.out.println(Arrays.toString(root));
        }

        public int numberOfRoots() {
            int[] freq = new int[root.length];
            int count = 0;
            for (int i = 0; i < root.length; i++) {
                int root = find(i);
                freq[root]++;
            }
            for (int x: freq) {
                if (x > 0) count++;
            }

            return count - 1;
        }
    }
}