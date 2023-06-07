// https://leetcode.com/problems/checking-existence-of-edge-length-limited-paths
class Solution {
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        boolean[] res = new boolean[queries.length];

        // Optimization 1: Try to always use arrays instead of collections.
        // While it won't theoretically improve time complexity, but can improve runtime performance.
        Query[] q = new Query[queries.length];
        Query[] unprocessed = new Query[edgeList.length];

        UnionFind uf = new UnionFind(n);
        int pi = 0;

        for (int i = 0; i < q.length; i++) {
            q[i] = new Query(i, queries[i]);
        }

        for (int i = 0; i < edgeList.length; i++) {
            unprocessed[i] = new Query(-1, edgeList[i]);
        }

        Arrays.sort(q);
        Arrays.sort(unprocessed);

        for (Query query: q) {
            int x = Math.min(query.x, query.y);
            int y = Math.max(query.x, query.y);

            // First check if the query x and y have same roots or not
            int rootX = uf.find(x);
            int rootY = uf.find(y);

            if (rootX == rootY) {
                res[query.i] = true;
                continue;
            }

            // Optimization 2: If the query dist is less than or equal to the first unprocessed
            // edge, then the result will always be false. Set the value to avoid recomputation.
            if (query.dist <= unprocessed[pi].dist) {
                res[query.i] = false;
                continue;
            }

            // At this point the edges may not have been processed
            // Optimization 3: Only process the edges that are strictly less than query limit.
            // This will save iterations.
            for (; pi < unprocessed.length; pi++) {
                Query edge = unprocessed[pi];
                if (edge.dist < query.dist) {
                    uf.union(edge.x, edge.y);
                } else {
                    break;
                }
            }

            // Check again
            rootX = uf.find(query.x);
            rootY = uf.find(query.y);

            if (rootX == rootY) {
                res[query.i] = true;
            }
        }

        return res;
    }

    // Will also hold edge data also.
    public class Query implements Comparable<Query> {
        int i, x, y, dist;

        public Query(int i, int[] data) {
            this.i = i;
            this.x = data[0];
            this.y = data[1];
            this.dist = data[2];
        }

        public int compareTo(Query other) {
            return this.dist - other.dist;
        }
    }

    // Quick union rank impl
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
    }
}