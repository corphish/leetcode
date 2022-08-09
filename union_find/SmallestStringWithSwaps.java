// https://leetcode.com/problems/smallest-string-with-swaps
class Solution {
    // Consider every index as a node in a graph.
    // Consider that for every element in a pair in pairs, there is a connection.
    // With UnionFind, we can make the connection for each vertex (index) in pairs.
    // Then for an index, we try to determine, in which chain or path it falls in.
    // For that path, we extract the chars from the indices denoted by the node values, we sort those chars and we put them
    // in the same indices, where the smallest char goes to the smallest index in path.
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        UnionFind uf = new UnionFind(n);
        
        for (var pair: pairs) {
            uf.union(pair.get(0), pair.get(1));
        }
        
        // Key = root, value = list of vertices whose root is key.
        Map<Integer, List<Integer>> roots = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = uf.find(i);
            List<Integer> vertices = roots.getOrDefault(root, new ArrayList<>());
            vertices.add(i);
            roots.put(root, vertices);
        }
        
        char[] res = new char[n];
        
        for (var vertices: roots.values()) {
            char[] temp = new char[vertices.size()];
            int i = 0;
            
            // Extract the chars from the required vertices (indexes)
            for (int ix: vertices) {
                temp[i++] = s.charAt(ix);
            }
            
            // Sort them to determine the lexicographically smallest string
            // that can be made from this chain of swaps denoted by UF.
            Arrays.sort(temp);
            
            // The list we are traversing ("vertices") is already sorted as we added "i" one by one
            // and i was coming from looping from 0..n-1.
            i = 0;
            for (int ix: vertices) {
                res[ix] = temp[i++];
            }
        }
        
        return new String(res);
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