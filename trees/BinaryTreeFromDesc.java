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
// https://leetcode.com/problems/create-binary-tree-from-descriptions
class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        Set<Integer> children = new HashSet<>();
        Map<Integer, TreeNode> map = new HashMap<>();
        
        for (int[] desc: descriptions) {
            int parent = desc[0];
            int child = desc[1];
            
            TreeNode childNode = map.getOrDefault(child, new TreeNode(child));
            TreeNode parentNode = map.getOrDefault(parent, new TreeNode(parent));
            
            if (desc[2] == 1) {
                parentNode.left = childNode;
            } else {
                parentNode.right = childNode;
            }
            
            map.put(child, childNode);
            map.put(parent, parentNode);
            
            children.add(child);
        }
        
        for (int parent: map.keySet()) {
            if (!children.contains(parent)) {
                return map.get(parent);
            }
        }
        
        return null;
    }
}