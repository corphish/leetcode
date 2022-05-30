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
class Solution {
    // Trick is to start adding left and right nodes to the leaf nodes, starting with n = 1.
    // Return empty list for even n.
    // We need to copy each root before adding.
    public List<TreeNode> allPossibleFBT(int n) {
        Map<Integer, List<TreeNode>> memo = new HashMap<>();
        
        memo.put(0, Arrays.asList());
        memo.put(1, Arrays.asList(new TreeNode(0)));
        
        if (n % 2 == 0) return memo.get(0);
        
        for (int i = 3; i <= n; i += 2) {
            List<TreeNode> r = new ArrayList<>();
            for (TreeNode l: memo.get(i - 2)) {
                build(l, r);
            }
            
            memo.put(i, r);
        }
        
        return memo.get(n);
    }
    
    void build(TreeNode root, List<TreeNode> store) {
        mainBuild(root, root, store);
    }
    
    void mainBuild(TreeNode root, TreeNode curr, List<TreeNode> store) {
        if (curr == null) {
            return;
        }
        
        if (curr.left == null && curr.right == null) {
            curr.left = new TreeNode(0);
            curr.right = new TreeNode(0);
            
            add(store, copyOf(root));
            
            curr.left = null;
            curr.right = null;
        }
        
        mainBuild(root, curr.left, store);
        mainBuild(root, curr.right, store);
    }
    
    TreeNode copyOf(TreeNode root) {
        if (root == null) {
            return null;
        }
        
        return copyMain(root, new TreeNode());
    }
    
    TreeNode copyMain(TreeNode root, TreeNode res) {
        if (root == null) {
            return res;
        }
        
        if (root.left != null) {
            res.left = new TreeNode();
            copyMain(root.left, res.left);
        }
        
        if (root.right != null) {
            res.right = new TreeNode();
            copyMain(root.right, res.right);
        }
        
        return res;
    }
    
    void add(List<TreeNode> store, TreeNode tree) {
        boolean isUnique = true;
        for (TreeNode t: store) {
            if (isEqual(t, tree)) {
                isUnique = false;
                break;
            }
        }
        
        if (isUnique) {
            store.add(tree);
        }
    }
    
    boolean isEqual(TreeNode a, TreeNode b) {
        if (a == null && b != null) {
            return false;
        }
        
        if (a != null && b == null) {
            return false;
        }
        
        if (a == null && b == null) {
            return true;
        }
        
        return isEqual(a.left, b.left) && isEqual(a.right, b.right);
    }
}