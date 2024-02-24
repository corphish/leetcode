// https://leetcode.com/problems/find-all-people-with-secret
class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        UnionFind uf = new UnionFind(n);
        Map<Integer, List<int[]>> timeMap = new TreeMap<>();

        uf.union(0, firstPerson);

        for (int[] m : meetings) {
            timeMap.computeIfAbsent(m[2], x -> new ArrayList<>()).add(m);
        }

        for (int t : timeMap.keySet()) {
            List<int[]> l = timeMap.get(t);

            for (int[] m : l) {
                uf.union(m[0], m[1]);
            }

            int target = uf.find(0);
            for (int[] m : l) {
                if (uf.find(m[0]) != target && uf.find(m[1]) != target) {
                    uf.reset(m[0]);
                    uf.reset(m[1]);
                }
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (uf.find(i) == uf.find(0)) {
                res.add(i);
            }
        }

        return res;
    }

    class UnionFind {
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

        public void reset(int x) {
            root[x] = x;
            rank[x] = 1;
        }

        public void union(int x, int y) {
            if (x < 0)
                return;
            if (y < 0)
                return;

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
            for (int x : freq) {
                if (x > 0)
                    count++;
            }

            System.out.println(Arrays.toString(root));

            return count;
        }
    }
}