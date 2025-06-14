// https://leetcode.com/problems/find-mirror-score-of-a-string/
class Solution {
    public long calculateScore(String s) {
        Map<Integer, Stack<Integer>> map = new HashMap<>();
        long sum = 0;
        int i = 0;

        for (char c: s.toCharArray()) {
            int ix = c - 'a';
            int mirror = 'z' - ix;

            Stack<Integer> st = map.get(mirror - 'a');
            if (st != null && !st.isEmpty()) {
                sum += i - st.pop();
            } else {
                map.computeIfAbsent(ix, x -> new Stack<>()).push(i);
            }

            i += 1;
        }

        return sum;
    }
}