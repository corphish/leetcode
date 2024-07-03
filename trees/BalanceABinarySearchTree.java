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
// https://leetcode.com/problems/balance-a-binary-search-tree 
class Solution {
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> store = new ArrayList<>();
        collect(root, store);
        return build(store, 0, store.size());
    }

    TreeNode build(List<Integer> store, int startInclusive, int endExclusive) {
        if (startInclusive >= endExclusive) {
            return null;
        }

        int mid = (startInclusive + endExclusive)/2;
        TreeNode node = new TreeNode(store.get(mid));
        node.left = build(store, startInclusive, mid);
        node.right = build(store, mid + 1, endExclusive);

        return node;
    }

    void collect(TreeNode root, List<Integer> store) {
        if (root == null) {
            return;
        }

        collect(root.left, store);
        store.add(root.val);
        collect(root.right, store);
    }
}