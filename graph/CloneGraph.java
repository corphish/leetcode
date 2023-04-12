// https://leetcode.com/problems/clone-graph
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        Map<Integer, List<Integer>> map = new TreeMap<>();
        Map<Integer, Node> nodes = new HashMap<>();

        collectNodes(node, map, new HashSet<>());

        Node res = null;
        for (var e: map.entrySet()) {
            Node n = nodes.get(e.getKey());
            if (n == null) {
                n = new Node(e.getKey());
                nodes.put(e.getKey(), n);
            }

            for (int nb: e.getValue()) {
                Node x = nodes.get(nb);
                if (x == null) {
                    x = new Node(nb);
                    nodes.put(nb, x);
                }

                n.neighbors.add(x);
            }

            if (res == null) {
                res = n;
            }
        }

        return res;    
    }

    void collectNodes(Node node, Map<Integer, List<Integer>> adj, Set<Integer> visited) {
        if (node == null) {
            return;
        }
        if (!visited.add(node.val)) {
            return;
        }

        if (adj.get(node.val) == null) {
            adj.put(node.val, new ArrayList<>());
        }

        for (Node n: node.neighbors) {
            adj.get(node.val).add(n.val);
            collectNodes(n, adj, visited);
        }
    }
}