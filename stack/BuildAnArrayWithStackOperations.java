// https://leetcode.com/problems/build-an-array-with-stack-operations
class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> res = new ArrayList<>();
        for (int i = 0, k = 1; i < target.length; i++, k++) {
            res.add("Push");
            if (target[i] != k) {
                res.add("Pop");
                i--;
            }
        }

        return res;
    }
}