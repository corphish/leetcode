// https://leetcode.com/problems/n-ary-tree-level-order-traversal/
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

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Node> queue = new ArrayDeque<>();
        
        if (root == null) {
            return res;
        }
        
        queue.add(root);
        
        while (!queue.isEmpty()) {
            Deque<Node> temp = new ArrayDeque<>();
            while (!queue.isEmpty()) {
                temp.addLast(queue.poll());
            }
            
            List<Integer> level = new ArrayList<>();
            for (Node t: temp) {
                level.add(t.val);
                
                for (Node n: t.children) {
                    queue.add(n);
                }
            }
            
            res.add(level);
        }
        
        return res;
    }
}