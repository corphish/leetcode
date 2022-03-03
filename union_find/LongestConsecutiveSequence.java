// https://leetcode.com/problems/longest-consecutive-sequence/
import java.util.*;

class LongestConsecutiveSequence {

    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2};
        System.out.println(longestConsecutive(nums));
    }

    static int longestConsecutive(int[] nums) {
        UnionFind uf = new UnionFind(nums);
        for (int x: nums) {
            uf.union(x, x - 1);
        }

        return uf.getMax();
    }
    
    static class UnionFind {
        Map<Integer, Integer> root;
        Map<Integer, Integer> rank;

        public UnionFind(int[] nums) {
            root = new HashMap<Integer, Integer>();
            rank = new HashMap<Integer, Integer>();

            for (int i = 0; i < nums.length; i++) {
                root.put(nums[i], nums[i]);
                rank.put(nums[i], 1);

                root.put(nums[i] - 1, nums[i] - 1);
                rank.put(nums[i] - 1, 1);
            }
        }

        public int find(int x) {
            //System.out.println(x);
            if (root.get(x) != x) {
                root.put(x, find(root.get(x)));
            }
            return root.get(x);
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX != rootY) {
                int rankX = rank.getOrDefault(rootX, 1);
                int rankY = rank.getOrDefault(rootY, 1);
                if (rankX > rankY) {
                    root.put(rootY, rootX);
                } else if (rankX < rankY) {
                    root.put(rootX, rootY);
                } else {
                    root.put(rootY, rootX);
                    rank.put(rootX, rankX + 1);
                }
            }
        }

        public int getMax() {
            int max = 0;
            Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
            for (int x: root.keySet()) {
                int root = find(x);
                freq.put(root, freq.getOrDefault(root, 0) + 1);
            }

            //System.out.println(root);

            for (int x: freq.values()) {
                if (x > 0) max = Math.max(max, x);
            }

            return max - 1;
        }
    }
}