// https://leetcode.com/problems/number-of-operations-to-make-network-connected
class Solution {
    public int makeConnected(int n, int[][] connections) {
        // To connect n nodes in graph, we need atleast n - 1
        // edges.
        int edges = connections.length;
        
        if (edges < n - 1) {
            return -1;
        }
        
        QuickUnionRank<Integer> uf = QuickUnionRank.intNodes(n);
        for (int[] conn: connections) {
            uf.union(conn[0], conn[1]);
        }
        
        // Answer will be total number of connected components - 1
        // Why? Consider each connected component as a node in graph
        // To connect all of them u need atleast (count - 1) edges, or operations
        // in this case.
        return uf.componentCount() - 1;
    }
    
    /**
     * Quick union implementation of Union Find with rank support and path compression.
     * Time complexity:
     * 1. Find - O(log(N))
     * 2. Union - O(log(N))
     * 3. Connected - O(log(N))
     * 
     * Space complexity: O(N)
     */
    public static class QuickUnionRank<T> {

        // Size
        private final int size;

        // Map to store the the nodes and roots
        private final Map<T, T> roots;
        private final Map<T, Integer> ranks;

        public QuickUnionRank(T[] nodes) {
            this.size = nodes.length;

            roots = new HashMap<>();
            ranks = new HashMap<>();

            // Set the roots of each node to itself
            for (T node: nodes) {
                roots.put(node, node);
                ranks.put(node, 1);
            }
        }

        public T find(T vertex) {
            if (vertex.equals(roots.get(vertex))) {
                return vertex;
            }

            roots.put(vertex, find(roots.get(vertex)));
            return roots.get(vertex);
        }

        public void union(T vertexA, T vertexB) {
            // Find the roots of both vertices
            T rootA = find(vertexA);
            T rootB = find(vertexB);

            // If roots dont match, then make root of 2nd vertex point to first vertex.
            // This works because vertexB's root was rootB whose root is now rootA.
            if (!rootA.equals(rootB)) {
                int rankA = ranks.get(rootA);
                int rankB = ranks.get(rootB);

                // The root that has the smaller rank, that root's root value will be changed to the one with bigger rank.
                if (rankA < rankB) {
                    roots.put(rootA, rootB);
                } else if (rankB < rankA) {
                    roots.put(rootB, rootA);
                } else {
                    // If both are equal, we set the root of B to A and increase rank of root by 1.
                    roots.put(rootB, rootA);
                    ranks.put(rootA, rankA + 1);
                }

            }
        }

        public boolean isConnected(T vertexA, T vertexB) {
            return find(vertexA).equals(find(vertexB));
        }

        public int getSize() {
            return size;
        }
        
        public int componentCount() {
            Set<T> r = new HashSet<>();
            for (T i: this.roots.keySet()) {
                r.add(find(i));
            }
            
            return r.size();
        }

        public static final QuickUnionRank<Integer> intNodes(int size) {
            Integer[] res = new Integer[size];

            for (int i = 0; i < size; i++) {
                res[i] = i;
            }

            return new QuickUnionRank<>(res);
        }
    }
}