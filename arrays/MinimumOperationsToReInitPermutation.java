// https://leetcode.com/problems/minimum-number-of-operations-to-reinitialize-a-permutation
class Solution {
    public int reinitializePermutation(int n) {
        int[] perm = new int[n];
        int count = 0;
        boolean isInitial = false;
        
        for (int i = 0; i < n; i++) {
            perm[i] = i;
        }
        
        while (!isInitial) {
            int[] arr = new int[n];
            boolean isSequential = true;
            
            for (int i = 0; i < n; i++) {
                arr[i] = i % 2 == 0? perm[i/2] : perm[n / 2 + (i - 1) / 2];
                if (i > 0 && arr[i] - arr[i - 1] != 1) {
                    isSequential = false;
                }
            }
            
            count++;
            
            if (isSequential) {
                isInitial = true;
            }
            
            perm = arr;
        }
        
        return count;
    }
}