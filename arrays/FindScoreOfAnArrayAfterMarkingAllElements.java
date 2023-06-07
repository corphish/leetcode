// https://leetcode.com/problems/find-score-of-an-array-after-marking-all-elements
class Solution {
    public long findScore(int[] nums) {
        Map<Integer, List<Integer>> map = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], x -> new ArrayList<>()).add(i);
        }

        long score = 0;
        Set<Integer> marked = new HashSet<>();
        for (var e: map.entrySet()) {
            int val = e.getKey();
            for (int ix: e.getValue()) {
                if (!marked.contains(ix)) {
                    score += val;
                    marked.add(ix);
                    marked.add(ix - 1);
                    marked.add(ix + 1);
                }
            }
        }

        return score;
    }
}