// https://leetcode.com/problems/number-of-closed-islands
class Solution {
    // Using union find, we find each island.
    // For each island, we check each block, and check if its surrounding is out of bounds or not
    // If not, we count it as closed
    public int closedIsland(int[][] grid) {
        List<String> nodes = new ArrayList<>();
        List<List<String>> conns = new ArrayList<>();
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    String key = keyOf(i, j);
                    // This block is an island, hence it is a node
                    nodes.add(key);
                    
                    // Check for adjacent connections
                    int v;
                    
                    // Top
                    v = safeAccess(grid, i - 1, j);
                    if (v == 0) {
                        // We have a connections
                        conns.add(Arrays.asList(key, keyOf(i - 1, j)));
                    }
                    
                    // Bottom
                    v = safeAccess(grid, i + 1, j);
                    if (v == 0) {
                        // We have a connections
                        conns.add(Arrays.asList(key, keyOf(i + 1, j)));
                    }
                    
                    // Left
                    v = safeAccess(grid, i, j - 1);
                    if (v == 0) {
                        // We have a connections
                        conns.add(Arrays.asList(key, keyOf(i, j - 1)));
                    }
                    
                    // Right
                    v = safeAccess(grid, i, j + 1);
                    if (v == 0) {
                        // We have a connections
                        conns.add(Arrays.asList(key, keyOf(i, j + 1)));
                    }
                }
            }
        }
        
        QuickUnionRank<String> uf = new QuickUnionRank<>(nodes);
        
        for (var conn: conns) {
            uf.union(conn.get(0), conn.get(1));
        }
        
        int count = 0;
        var islands = uf.rootAndVerticesMap().values();
        for (List<String> island: islands) {
            boolean isClosed = true;
            for (String block: island) {
                int[] ix = parseKey(block);
                
                int t = safeAccess(grid, ix[0] - 1, ix[1]);
                int b = safeAccess(grid, ix[0] + 1, ix[1]);
                int l = safeAccess(grid, ix[0], ix[1] - 1);
                int r = safeAccess(grid, ix[0], ix[1] + 1);
                
                if (t < 0 || b < 0 || l < 0 || r < 0) {
                    isClosed = false;
                    break;
                }
            }
            
            if (isClosed) {
                count++;
            }
        }
        
        return count;
    }
    
    String keyOf(int i, int j) {
        return i + "," + j;
    }
    
    int safeAccess(int[][] arr, int i, int j) {
        if (i < 0 || i >= arr.length) return -1;
        if (j < 0 || j >= arr[0].length) return -1;
        
        return arr[i][j];
    }
    
    int[] parseKey(String key) {
        String[] parts = key.split(",");
        return new int[] {
            Integer.parseInt(parts[0]),
            Integer.parseInt(parts[1]),
        };
    }
    
    class QuickUnionRank<T> {

        // Size
        private final int size;

        // Map to store the the nodes and roots
        private final Map<T, T> roots;
        private final Map<T, Integer> ranks;

        public QuickUnionRank(List<T> nodes) {
            this.size = nodes.size();

            roots = new HashMap<>();
            ranks = new HashMap<>();

            // Set the roots of each node to itself
            for (T node: nodes) {
                roots.put(node, node);
                ranks.put(node, 1);
            }
        }

        public T find(T vertex) {
            if (vertex == null) {
                return vertex;
            }
            
            if (vertex.equals(roots.get(vertex))) {
                return vertex;
            }

            roots.put(vertex, find(roots.get(vertex)));
            return roots.get(vertex);
        }
        
        public T directFind(T vertex) {
            return roots.get(vertex);
        }

        public void union(T vertexA, T vertexB) {
            if (vertexA.equals(vertexB)) {
                return;
            }
            
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
        
        public Map<T, List<T>> rootAndVerticesMap() {
            Map<T, List<T>> map = new HashMap<>();
            for (T node: roots.keySet()) {
                T root = find(node);
                List<T> vertices = map.getOrDefault(root, new ArrayList<>());
                vertices.add(node);
                map.put(root, vertices);
            }
            
            return map;
        }
    }
}