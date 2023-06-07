// https://leetcode.com/problems/remove-max-number-of-edges-to-keep-graph-fully-traversable
class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        int count = 0;

        UnionFind alice = new UnionFind(n);
        UnionFind bob = new UnionFind(n);

        for (int[] edge: edges) {
            int type = edge[0];
            int u = edge[1] - 1, v = edge[2] - 1;

            if (type != 3) {
                continue;
            }

            // Check if both nodes have same root for both people
            if (alice.find(u) == alice.find(v) && bob.find(u) == bob.find(v)) {
                // We can remove this edge
                count += 1;
                continue;
            }

            // Else we union
            alice.union(u, v);
            bob.union(u, v);
        }

        for (int[] edge: edges) {
            int type = edge[0];
            int u = edge[1] - 1, v = edge[2] - 1;

            if (type == 3) {
                continue;
            }

            // Check if both nodes have same root for both people
            if ((type == 1 && alice.find(u) == alice.find(v)) || (type == 2 && bob.find(u) == bob.find(v))) {
                // We can remove this edge
                count += 1;
                continue;
            }

            // Else we union
            if (type == 1)
                alice.union(u, v);

            if (type == 2)
                bob.union(u, v);
        }

        int aliceCount = alice.numberOfRoots();
        int bobCount = bob.numberOfRoots();

        if (aliceCount > 1 || bobCount > 1) {
            return -1;
        }

        return count;
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

            return count;
        }
    }
}