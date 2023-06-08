// https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box
class Solution {
    public int[] minOperations(String boxes) {
        int[] res = new int[boxes.length()];
        byte[] arr = boxes.getBytes();
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res.length; j++) {
                if (i != j && arr[j] == '1') {
                    res[i] += Math.abs(i - j);
                }
            }
        }

        return res;
    }
}