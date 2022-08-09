// https://leetcode.com/problems/count-sub-islands
class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid1.length, n = grid1[0].length;
        
        // Nodes are the lands
        // Nodes of grid 1
        List<String> nodes1 = new ArrayList<>();
        
        // Nodes of grid 2
        List<String> nodes2 = new ArrayList<>();
        
        // Connections: List of pair of string indicating a connection between each of the item in the pair.
        // A pair is a list of 2 items.
        // Connections for grid 1
        List<List<String>> conns1 = new ArrayList<>();
        
        // Connections for grid 2
        List<List<String>> conns2 = new ArrayList<>();
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                String key = keyOf(i, j);
                
                // Check if this is a land on grid1
                if (grid1[i][j] == 1) {
                    // This block is an island, hence it is a node
                    nodes1.add(key);
                    
                    // Check for adjacent connections
                    int v;
                    
                    // Top
                    v = safeAccess(grid1, i - 1, j);
                    if (v == 1) {
                        // We have a connections
                        conns1.add(Arrays.asList(key, keyOf(i - 1, j)));
                    }
                    
                    // Bottom
                    v = safeAccess(grid1, i + 1, j);
                    if (v == 1) {
                        // We have a connections
                        conns1.add(Arrays.asList(key, keyOf(i + 1, j)));
                    }
                    
                    // Left
                    v = safeAccess(grid1, i, j - 1);
                    if (v == 1) {
                        // We have a connections
                        conns1.add(Arrays.asList(key, keyOf(i, j - 1)));
                    }
                    
                    // Right
                    v = safeAccess(grid1, i, j + 1);
                    if (v == 1) {
                        // We have a connections
                        conns1.add(Arrays.asList(key, keyOf(i, j + 1)));
                    }
                }
                
                // Check if this is a land on grid2
                if (grid2[i][j] == 1) {
                    // This block is an island, hence it is a node
                    nodes2.add(key);
                    
                    // Check for adjacent connections
                    int v;
                    
                    // Top
                    v = safeAccess(grid2, i - 1, j);
                    if (v == 1) {
                        // We have a connections
                        conns2.add(Arrays.asList(key, keyOf(i - 1, j)));
                    }
                    
                    // Bottom
                    v = safeAccess(grid2, i + 1, j);
                    if (v == 1) {
                        // We have a connections
                        conns2.add(Arrays.asList(key, keyOf(i + 1, j)));
                    }
                    
                    // Left
                    v = safeAccess(grid2, i, j - 1);
                    if (v == 1) {
                        // We have a connections
                        conns2.add(Arrays.asList(key, keyOf(i, j - 1)));
                    }
                    
                    // Right
                    v = safeAccess(grid2, i, j + 1);
                    if (v == 1) {
                        // We have a connections
                        conns2.add(Arrays.asList(key, keyOf(i, j + 1)));
                    }
                }
            }
        }
        
        QuickUnionRank<String> uf1 = new QuickUnionRank<>(nodes1);
        QuickUnionRank<String> uf2 = new QuickUnionRank<>(nodes2);
        
        for (var pair: conns1) {
            uf1.union(pair.get(0), pair.get(1));
        }
        
        for (var pair: conns2) {
            uf2.union(pair.get(0), pair.get(1));
        }
        
        // For each island block in grid 2, check if its root is a land in grid 1
        var islands2 = uf2.rootAndVerticesMap().values();
        int count = 0;
        for (List<String> island: islands2) {
            boolean isSubIsland = true;
            for (String block: island) {
                String rootInGrid1 = uf1.directFind(block);
                
                if (rootInGrid1 == null) {
                    //System.out.println(block + " seems to be a water in island1. " + island + " will be discarded.");
                    isSubIsland = false;
                    break;
                }
            }
            
            if (isSubIsland) {
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