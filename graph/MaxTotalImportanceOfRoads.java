// https://leetcode.com/problems/maximum-total-importance-of-roads
class Solution {
    // Higher importance should be assigned to the nodes having the highest degree (no. of edges coming to, going from it).
    // Maximum sum will be the sum of importances associated to the nodes, summation should be done if there is an edge from
    // node a to node b and summation of node b and node has not been done already.
    public long maximumImportance(int n, int[][] roads) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        
        // Build an undirected adj
        for (int[] road: roads) {
            adj.computeIfAbsent(road[0], k -> new ArrayList<>()).add(road[1]);
            adj.computeIfAbsent(road[1], k -> new ArrayList<>()).add(road[0]);
        }
        
        //System.out.println(adj);
        
        Set<Node> sorted = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            sorted.add(new Node(i, adj.getOrDefault(i, new ArrayList<>()).size()));
        }
        
        int[] importance = new int[n];
        int k = n;
        long sum = 0;
        
        for (Node node: sorted) {
            importance[node.vertex] = k--;
        }
        
        //System.out.println(sorted);
        //System.out.println(Arrays.toString(importance));
        
        Set<Integer> visited = new HashSet<>();
        for (var e: adj.entrySet()) {
            for (int x: e.getValue()) {
                if (!visited.contains(x)) {
                    sum += importance[e.getKey()] + importance[x];
                }
            }
            
            visited.add(e.getKey());
        }
        
        return sum;
    }
    
    class Node implements Comparable<Node> {
        int vertex;
        int edges;
        
        Node(int vertex, int edges) {
            this.vertex = vertex;
            this.edges = edges;
        }
        
        public int compareTo(Node other) {
            return other.edges == this.edges ? this.vertex - other.vertex : other.edges - this.edges;
        }
        
        public String toString() {
            return "{vertex=" + vertex + ", edges=" + edges + "}";
        }
    }
}