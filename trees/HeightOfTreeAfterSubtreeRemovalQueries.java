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
// https://leetcode.com/problems/height-of-binary-tree-after-subtree-removal-queries 
class Solution {
    public int[] treeQueries(TreeNode root, int[] queries) {
        Map<Integer, Integer> levelMap = new HashMap<>();
        Map<Integer, List<Integer>> invLevelMap = new HashMap<>();
        Map<Integer, Integer> dist = new HashMap<>();

        traverse(root, 0, levelMap, invLevelMap, dist);

        Map<Integer, Integer> levelMax = new HashMap<>();
        Map<Integer, Integer> levelSecondMax = new HashMap<>();

        for (var e: invLevelMap.entrySet()) {
            int max = 0, second = 0;
            int maxNode = -1, secondMaxNode = -1;

            for (int x: e.getValue()) {
                int d = dist.get(x);
                if (d > max) {
                    second = max;
                    secondMaxNode = maxNode;
                    max = d;
                    maxNode = x;
                } else if (d > second) {
                    second = d;
                    secondMaxNode = x;
                }
            }

            levelMax.put(e.getKey(), maxNode);
            levelSecondMax.put(e.getKey(), secondMaxNode);
        }

        int[] res = new int[queries.length];

        for (int i = 0; i < res.length; i++) {
            int levelOfDeletedNode = levelMap.get(queries[i]);
            int maxOfThatLevel = levelMax.get(levelOfDeletedNode);
            int max = levelMap.get(queries[i]) - 1;

            if (maxOfThatLevel != queries[i]) {
                max = dist.get(maxOfThatLevel);
            } else {
                int secondMaxOfThatLevel = levelSecondMax.get(levelOfDeletedNode);
                if (secondMaxOfThatLevel != -1) {
                    max = dist.get(secondMaxOfThatLevel);
                }
            }

            res[i] = max;
        }

        return res;
    }

    int traverse(
        TreeNode root,
        int level,
        Map<Integer, Integer> levelMap,
        Map<Integer, List<Integer>> invLevelMap,
        Map<Integer, Integer> dist
    ) {
        if (root == null) {
            return 0;
        }

        levelMap.put(root.val, level);
        invLevelMap.computeIfAbsent(level, x -> new ArrayList<>()).add(root.val);

        if (root.left == null && root.right == null) {
            dist.put(root.val, level);
            return level;
        }

        int max = Math.max(
            traverse(root.left, level + 1, levelMap, invLevelMap, dist), 
            traverse(root.right, level + 1, levelMap, invLevelMap, dist)
        );

        dist.put(root.val, max);

        return max;
    }
}