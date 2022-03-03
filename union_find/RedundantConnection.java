import java.util.*;

class RedundantConnection {

    public static void main(String[] args) {
        int[][] edges = {{1,2},{2,3},{3,4},{1,4},{1,5}};
        System.out.println(Arrays.toString(redundantConnection(edges)));
    }

    static int[] redundantConnection(int[][] edges) {
        int n = 0;
        int[] res = new int[2];
        for (int[] edge : edges) {
            n = Math.max(n, edge[0]);
            n = Math.max(n, edge[1]);
        }

        UnionFind uf = new UnionFind(n + 1);
        Set<Integer> visited = new HashSet<>();

        for (int[] edge: edges) {
            int root = uf.union(edge[1], edge[0]);
            if (visited.contains(root)) {
                res = edge;
            }

            visited.add(root);
        }

        return res;
    }

    static class UnionFind {
        int[] root;
        int[] rank;

        UnionFind(int size) {
            root = new int[size];
            rank = new int[size];

            for (int i = 0; i < size; i++) {
                root[i] = i;
                rank[i] = 1;
            }
        }

        int find(int x) {
            if (x == root[x]) {
                return x;
            }

            return root[x] = find(root[x]);
        }

        int union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    root[rootY] = rootX;
                    return rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    root[rootX] = rootY;
                    return rootY;
                } else {
                    root[rootY] = rootX;
                    rank[rootX] += 1;
                    return rootX;
                }
            }

            return rootX;
        }
    }
}