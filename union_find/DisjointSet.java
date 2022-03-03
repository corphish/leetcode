/**
 * Disjoint Set implementation with union by rank and
 * path compression.
 */
class DisjointSet {
    // Array to store parent/root indexes
    int[] root;
    
    // Array to store rank
    int[] rank;
    
    // Constructor
    DisjointSet(int size) {
        root = new int[size];
        rank = new int[size];
        
        for (int i = 0; i < size; i++) {
            root[i] = i;
            rank[i] = 1;
        }
    }
    
    // Find method with path compression
    int find(int x) {
        // If the value of node is same as its index
        // then that means it is the root node.
        if (x == root[x]) {
            return x;
        }
        
        // Recursively update the root array value with the root node.
        return root[x] = find(root[x]);
    }
    
    // Union method, using union by rank
    void union(int x, int y) {
        // Find the root nodes of both vertices.
        int rootX = find(x);
        int rootY = find(y);
        
        // We will consider the graph which has the higher rank
        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                root[rootX] = rootY;
            } else {
                // When both the graphs have same height,
                // we make the parent of root of y as root of x,
                // and increment the rank of root of x by 1.
                root[rootY] = rootX;
                rank[rootX] += 1;
            }
        }
    }
    
    // Checks if 2 vertices are connected.
    // In other words, check if the root nodes of 2 vertices
    // are same.
    boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}