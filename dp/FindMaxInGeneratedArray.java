class Solution {
    // Simple ad hoc, but we need to check max when a value set is successful.
    public int getMaximumGenerated(int n) {
        if (n < 2) return n;
        int[] arr = new int[n + 1];
        
        arr[1] = 1;
        int max = 1;
        
        for (int i = 1; i <= n/2; i++) {
            if (safePut(arr, 2 * i, arr[i])) {
                max = Math.max(max, arr[i]);
            }
            
            if (safePut(arr, 2 * i + 1, arr[i] + arr[i + 1])) {
                max = Math.max(max, arr[i] + arr[i + 1]);
            }
        }
        
        return max;
    }
    
    boolean safePut(int[] arr, int i, int v) {
        if (i < 0 || i >= arr.length) return false;
        arr[i] = v;
        return true;
    }
}