/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
// https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<LeveledValue> list = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        
        preorder(root, 0, 0, list);
        
        Collections.sort(list);
        
        Map<Integer, List<Integer>> map = new TreeMap<>();
        for (LeveledValue value: list) {
            map.computeIfAbsent(value.x, i -> new ArrayList<>()).add(value.value);
        }
        
        for (List<Integer> level: map.values()) {
            res.add(level);
        }
        
        return res;
    }
    
    void preorder(TreeNode root, int x, int y, List<LeveledValue> list) {
        if (root == null) {
            return;
        }
        
        list.add(new LeveledValue(root.val, x, y));
        
        preorder(root.left, x - 1, y + 1, list);
        preorder(root.right, x + 1, y + 1, list);
    }
    
    class LeveledValue implements Comparable<LeveledValue> {
        int value, x, y;
        
        LeveledValue(int value, int x, int y) {
            this.value = value;
            this.x = x;
            this.y = y;
        }
        
        public int compareTo(LeveledValue other) {
            return this.x == other.x ? this.y == other.y ? this.value - other.value : this.y - other.y : this.x - other.x;
        }
        
        public String toString() {
            return value + " at (" + x + ", " + y + ")";
        }
    }
}