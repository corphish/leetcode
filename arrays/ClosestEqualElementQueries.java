// https://leetcode.com/problems/closest-equal-element-queries/
class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], x -> new ArrayList<>()).add(i);
        }

        for (int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], x -> new ArrayList<>()).add(nums.length + i);
        }

        for (int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], x -> new ArrayList<>()).add(2 * nums.length + i);
        }

        List<Integer> res = new ArrayList<>();
        for (int x: queries) {
            int num = nums[x];
            List<Integer> list = map.get(num);

            if (list.size() == 3) {
                res.add(-1);
                continue;
            }

            int ix = Collections.binarySearch(list, x + nums.length);
            int min = Integer.MAX_VALUE;
            if (ix - 1 >= 0) {
                min = Math.min(min, list.get(ix) - list.get(ix - 1));
            }

            if (ix + 1 < list.size()) {
                min = Math.min(min, list.get(ix + 1) - list.get(ix));
            }

            res.add(min);
        }

        return res;
    }
}