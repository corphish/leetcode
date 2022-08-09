// https://leetcode.com/problems/surrounded-regions
class Solution {
    // Same as Number of Closed islands problem (https://leetcode.com/problems/number-of-closed-islands/), but here we detect those islands
    // which have
    // 1. Atleast one 'X' in each of the 4 directions.
    // 2. Any position in that island is not situated in the edge.
    // If the above 2 are satisfied, we transform this island into 'X's.
    public void solve(char[][] grid) {
        List<String> nodes = new ArrayList<>();
        List<List<String>> conns = new ArrayList<>();
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 'O') {
                    String key = keyOf(i, j);
                    // This block is an island, hence it is a node
                    nodes.add(key);
                    
                    // Check for adjacent connections
                    char v;
                    
                    // Top
                    v = safeAccess(grid, i - 1, j);
                    if (v == 'O') {
                        // We have a connections
                        conns.add(Arrays.asList(key, keyOf(i - 1, j)));
                    }
                    
                    // Bottom
                    v = safeAccess(grid, i + 1, j);
                    if (v == 'O') {
                        // We have a connections
                        conns.add(Arrays.asList(key, keyOf(i + 1, j)));
                    }
                    
                    // Left
                    v = safeAccess(grid, i, j - 1);
                    if (v == 'O') {
                        // We have a connections
                        conns.add(Arrays.asList(key, keyOf(i, j - 1)));
                    }
                    
                    // Right
                    v = safeAccess(grid, i, j + 1);
                    if (v == 'O') {
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
        
        var islands = uf.rootAndVerticesMap().values();
        for (List<String> island: islands) {
            int[] dir = {0, 0, 0, 0};
            boolean isInEdge = false;
            for (String block: island) {
                int[] ix = parseKey(block);
                
                char t = safeAccess(grid, ix[0] - 1, ix[1]);
                char b = safeAccess(grid, ix[0] + 1, ix[1]);
                char l = safeAccess(grid, ix[0], ix[1] - 1);
                char r = safeAccess(grid, ix[0], ix[1] + 1);
                
                if (t == 'X') dir[0]++;
                if (b == 'X') dir[1]++;
                if (l == 'X') dir[2]++;
                if (r == 'X') dir[3]++;
                
                if (t == 'o') isInEdge = true;
                if (b == 'o') isInEdge = true;
                if (l == 'o') isInEdge = true;
                if (r == 'o') isInEdge = true;
            }
            
            Arrays.sort(dir);
            
            if (!isInEdge && dir[0] > 0) {
                for (String block: island) {
                    int[] ix = parseKey(block);

                    grid[ix[0]][ix[1]] = 'X';
                }
            }
        }
    }
    
    String keyOf(int i, int j) {
        return i + "," + j;
    }
    
    char safeAccess(char[][] arr, int i, int j) {
        if (i < 0 || i >= arr.length) return 'o';
        if (j < 0 || j >= arr[0].length) return 'o';
        
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