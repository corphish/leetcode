// https://leetcode.com/problems/merge-triplets-to-form-target-triplet/
class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] res = {0, 0, 0};
        
        for (int[] arr: triplets) {
            // First check if we have any element of triplet matching its corresponding
            // index in target, and the consider it only if other elements are smaller or equal to
            // the target.
            if (arr[0] == target[0] || arr[1] == target[1] || arr[2] == target[2]) {
                if (arr[0] <= target[0] && arr[1] <= target[1] && arr[2] <= target[2]) {
                    res[0] = Math.max(res[0], arr[0]);
                    res[1] = Math.max(res[1], arr[1]);
                    res[2] = Math.max(res[2], arr[2]);
                }
            }
        }
        
        return res[0] == target[0] && res[1] == target[1] && res[2] == target[2];
    }
}