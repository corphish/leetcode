// https://leetcode.com/problems/path-sum-ii
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
// Thumb rule:
// 1. If root is null, return empty list
// 2. If target sum - root.val is 0, we return a list of list with 1 item having root.val.
// 3. We recursively inflate the list.
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return new ArrayList<>();
        }
        
        //System.out.println("Target = " + targetSum);
        
        if (targetSum - root.val == 0) {
            // Only return  if root is leaf
            if (root.left == null && root.right == null) {
                //System.out.println("Leaf");
                List<Integer> inner = new ArrayList<>();
                List<List<Integer>> outer = new ArrayList<>();
                
                inner.add(root.val);
                
                outer.add(inner);
                return outer;
            }
        }
        
        List<List<Integer>> res = new ArrayList<>();
        
        List<List<Integer>> left = pathSum(root.left, targetSum - root.val);
        List<List<Integer>> right = pathSum(root.right, targetSum - root.val);
        
        //System.out.println("Left = " + left);
        //System.out.println("Right = " + right);
        
        for (var l: left) {
            List<Integer> e = new ArrayList<>();
            e.add(root.val);
            e.addAll(l);
            res.add(e);
        }
        
        for (var l: right) {
            List<Integer> e = new ArrayList<>();
            e.add(root.val);
            e.addAll(l);
            res.add(e);
        }
        
        return res;
    }

    // Alternate
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, targetSum, new Stack<>(), res);
        return res;
    }
    
    void dfs(TreeNode root, int target, Stack<Integer> path, List<List<Integer>> store) {
        if (root == null) {
            return;
        }
        
        if (root.left == null && root.right == null && target - root.val == 0) {
            path.push(root.val);
            store.add(new ArrayList<>(path));
            path.pop();
            return;
        }
        
        path.push(root.val);
        dfs(root.left, target - root.val, path, store);
        dfs(root.right, target - root.val, path, store);
        path.pop();
    }
}