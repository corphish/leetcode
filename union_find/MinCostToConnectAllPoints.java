// https://leetcode.com/problems/min-cost-to-connect-all-points
class Solution {
    public int minCostConnectPoints(int[][] points) {
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                edges.add(new Edge(points[i], points[j], i, j));
            }
        }

        Collections.sort(edges);
        int min = 0;
        UnionFind uf = new UnionFind(points.length);

        for (Edge e: edges) {
            int rootFrom = uf.find(e.from);
            int rootTo = uf.find(e.to);

            if (rootFrom != -1 && rootTo != -1 && rootFrom != rootTo) {
                min += e.weight;
                uf.union(e.from, e.to);
            }
        }

        return min;
    }

    class Edge implements Comparable<Edge> {
        int from, to, weight;

        Edge(int[] src, int[] dst, int from, int to) {
            this.from = from;
            this.to = to;
            this.weight = dist(src, dst);
        }

        public int compareTo(Edge other) {
            return this.weight - other.weight;
        }
    }

    int dist(int[] src, int[] dst) {
        return Math.abs(src[0] - dst[0]) + Math.abs(src[1] - dst[1]);
    }

    class UnionFind {
        int[] root;
        int[] rank;
        
        UnionFind(int size) {
            root = new int[size];
            rank = new int[size];
            
            for (int i = 0; i < size; i++) {
                root[i] = i;
                rank[i] = i;
            }
        }
        
        int find(int x) {
            if (x == root[x]) {
                return x;
            }
            
            return root[x] = find(root[x]);
        }
        
        void union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);
            
            if (rootA < rootB) {
                root[rootA] = rootB;
            } else if (rootB < rootA) {
                root[rootB] = rootA;
            } else {
                root[rootB] = rootA;
                rank[rootA] += 1;
            }
        }
    }
}