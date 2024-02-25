// https://leetcode.com/problems/greatest-common-divisor-traversal/
class Solution {
    public boolean canTraverseAllPairs(int[] nums) {
        if (nums.length == 1) {
            return true;
        }

        Set<Integer> set = new HashSet<>();
        int max = 0;
        for (int x : nums) {
            max = Math.max(x, max);
            if (x > 1)
                set.add(x);
        }

        if (set.isEmpty()) {
            return false;
        }

        Map<Integer, List<Integer>> map = sieveOfEratosthenes(max, set);
        DisjointSetExt uf = new DisjointSetExt(max + 1);
        for (int x : map.keySet()) {
            List<Integer> l = map.get(x);
            for (int i = 1; i < l.size(); i++) {
                uf.union(l.get(i), l.get(i - 1));
            }
        }

        int target = -1;
        for (int x : nums) {
            if (target == -1) {
                target = uf.find(x);
            } else if (uf.find(x) != target) {
                return false;
            }
        }

        return true;
    }

    Map<Integer, List<Integer>> sieveOfEratosthenes(int n, Set<Integer> set) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        // Create a boolean array "prime[0..n]" and
        // initialize all entries it as true. A value in
        // prime[i] will finally be false if i is Not a
        // prime, else true.
        boolean prime[] = new boolean[n + 1];
        for (int i = 0; i <= n; i++)
            prime[i] = true;

        for (int p = 2; p <= n / 2; p++) {
            // If prime[p] is not changed, then it is a
            // prime
            if (prime[p] == true) {
                // Update all multiples of p greater than or
                // equal to the square of it numbers which
                // are multiple of p and are less than p^2
                // are already been marked.
                if (set.contains(p)) {
                    map.computeIfAbsent(p, y -> new ArrayList<>()).add(p);
                }

                for (int i = 2 * p; i <= n; i += p) {
                    prime[i] = false;
                    if (set.contains(i)) {
                        map.computeIfAbsent(p, y -> new ArrayList<>()).add(i);
                    }
                }
            }
        }

        // Print all prime numbers
        return map;
    }

    class DisjointSetExt extends DisjointSet {
        DisjointSetExt(int size) {
            super(size);
        }

        int numberOfRoots() {
            int[] freq = new int[root.length];
            for (int i = 0; i < root.length; i++) {
                int root = find(i);
                freq[root]++;
            }

            int count = 0;
            for (int i = 0; i < root.length; i++) {
                if (freq[i] > 0)
                    count++;
            }

            return count;
        }
    }

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
}