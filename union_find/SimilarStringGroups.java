// https://leetcode.com/problems/similar-string-groups/
class Solution {
    public int numSimilarGroups(String[] strs) {
        int n = strs.length, wordLen = strs[0].length();

        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (areSimilar(strs[i], strs[j])) {
                    uf.union(i, j);
                }
            }
        }

        return uf.numberOfRoots();
    }

    boolean areSimilar(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
            }
        }

        return diff == 0 || diff == 2;
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