// https://leetcode.com/problems/convert-an-array-into-a-2d-array-with-conditions
class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        int[] freq = new int[nums.length + 1];
        for (int x: nums) freq[x]++;

        List<List<Integer>> res = new ArrayList<>();
        while (true) {
            List<Integer> row = new ArrayList<>();
            boolean added = false;
            for (int i = 1; i < freq.length; i++) {
                if (freq[i] > 0) {
                    row.add(i);
                    added = true;
                    freq[i]--;
                }
            }

            if (added) {
                res.add(row);
            } else {
                break;
                }
        }

        return res;
    }
}