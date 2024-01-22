// https://leetcode.com/problems/diagonal-traverse-ii
class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        int count = 0;
        Map<Integer, List<Integer>> map = new TreeMap<>();

        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.get(i).size(); j++) {
                count += 1;
                map.computeIfAbsent(i + j, x -> new LinkedList<>()).add(0, nums.get(i).get(j));
            }
        }

        int[] res = new int[count];
        int k = 0;
        for (List<Integer> v: map.values()) {
            for (int x: v) {
                res[k++] = x;
            }
        }

        return res;
    }
}