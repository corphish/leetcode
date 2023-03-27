// https://leetcode.com/problems/count-unreachable-pairs-of-nodes-in-an-undirected-graph
class Solution {
    public long countPairs(int n, int[][] edges) {
        long count = 0;
        QuickUnionRank<Integer> uf = QuickUnionRank.intNodes(n);
        for (int[] edge: edges) {
            uf.union(edge[0], edge[1]);
        }

        uf.analyseConnections();
        for (int i = 0; i < n; i++) {
            count += uf.distantNodesCount(i);
        }

        return count/2;
    }

    public static class QuickUnionRank<T> {
        // Size
        private final int size;
        private final T[] nodes;

        // Map to store the the nodes and roots
        private final Map<T, T> roots;
        private final Map<T, Integer> ranks;
        private final Map<T, List<T>> connections;
        
        public QuickUnionRank(T[] nodes) {
            this.nodes = nodes;
            this.size = nodes.length;

            roots = new HashMap<>();
            ranks = new HashMap<>();
            connections = new HashMap<>();

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

        // Groups the connected components in a map.
        public void analyseConnections() {
            for (T node: nodes) {
                connections.computeIfAbsent(find(node), x -> new ArrayList<>()).add(node);
            }
        }

        /**
         * Returns the no. of nodes that the given node is not connected to.      
         */
        public int distantNodesCount(T node) {
            int neighbors = connections.getOrDefault(find(node), new ArrayList<>()).size();
            return size - neighbors;
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