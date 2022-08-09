/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
// https://leetcode.com/problems/n-ary-tree-postorder-traversal/
class Solution {
    // Either we can do a post order traversal in separate function and
    // accumulate the results.
    // Or we can do it within the same function.
    // If we are going to do the later,
    // we return empty list for null roots.
    // we add the list result from traversing the children first and then add the current node value
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        
        if (root == null) {
            return res;
        }
        
        for (Node n: root.children) {
            List<Integer> fromChild = postorder(n);
            res.addAll(fromChild);
        }
        
        res.add(root.val);
        
        return res;
    }
}