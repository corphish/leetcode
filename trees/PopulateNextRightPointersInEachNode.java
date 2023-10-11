/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
// https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
class Solution {
    public Node connect(Node root) {
        if (root == null) return root;
        
        Queue<Node> queue = new ArrayDeque<>();
        Queue<Node> temp = new ArrayDeque<>();
        
        queue.add(root);
        
        do {
            Node last = null;
            temp.addAll(queue);
            queue.clear();
            while (!temp.isEmpty()) {
                Node n = temp.poll();
                if (last != null) {
                    last.next = n;
                }
                
                last = n;
                
                if (n.left != null) {
                    queue.add(n.left);
                }
                
                if (n.right != null) {
                    queue.add(n.right);
                }
            }
            
            last.next = null;
        } while (!queue.isEmpty());
        
        return root;
    }
}