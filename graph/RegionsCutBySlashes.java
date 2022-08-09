// https://leetcode.com/problems/regions-cut-by-slashes
class Solution {
    public int regionsBySlashes(String[] grid) {
        // We consider each points in corner of each element as dots
        // So a setup of
        // [' ', ' ']
        // [' ', ' ']
        // looks like
        // . . .
        // . . .
        // . . .
        // (As it is difficult to represent the slashes in dot diagram)
        // A slash connects 2 dots
        // Edges are connected
        // Question now becomes to find the no. of cycles in the graph
        
        int n = grid.length;
        int dots = n + 1;
        
        UnionFind uf = new UnionFind(dots * dots);
        
        // Connect the edges
        for (int i = 0; i < dots; i++) {
            for (int j = 0; j < dots; j++) {
                if (i == 0 || i == dots - 1 || j == 0 || j == dots - 1) {
                    int cell = i * dots + j;
                    
                    // We assume that the root of the edges is [0, 0] whose cell value
                    // is 0.
                    if (cell != 0) {
                        uf.union(0, cell);
                    }
                }
            }
        }
        
        // Now we examine the slashes and union them
        // We union them from bottom (2nd arg of union) to top (1st arg).
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char c = grid[i].charAt(j);
                if (c == '/') {
                    // Bottom left = (i + 1, j)
                    int bottomLeft = (i + 1) * dots + j;
                    
                    // Top right = (i, j + 1)
                    int topRight = i * dots + j + 1;
                    
                    // Union
                    uf.union(topRight, bottomLeft);
                } else if (c == '\\') {
                    // Top left = (i, j)
                    int topLeft = i * dots + j;
                    
                    // Bottom right = (i + 1, j + 1)
                    int bottomRight = (i + 1) * dots + j + 1;
                    
                    // Union
                    uf.union(topLeft, bottomRight);
                }
            }
        }
        
        return uf.regions;
    }
    
    class UnionFind {
        int[] root;
        int[] rank;
        int regions;
        
        public UnionFind(int n) {
            root = new int[n];
            rank = new int[n];
            
            regions = 1;
            
            for (int i = 0; i < n; i++) {
                root[i] = i;
                rank[i] = 0;
            }
        }
        
        int find(int x) {
            if (x == root[x]) {
                return x;
            }
            
            return root[x] = find(root[x]);
        }
        
        void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            
            if (rootX != rootY) {
                if (rank[rootX] < rank[rootY]) {
                    root[rootX] = rootY;
                } else if (rank[rootY] < rank[rootY]) {
                    root[rootY] = rootX;
                } else {
                    root[rootX] = rootY;
                    rank[rootY] += 1;
                }
            } else {
                // This is very interesting
                // If this condition is true, and x != y, then a cycle is present in the graph
                regions += 1;
            }
        }
    }
}