class Solution {
    // Pattern = [0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 2, 3, 2, 3, 3, 4]
    // res[0] = 0, res[1] = 1
    // Then for every k times (starting with k = 1), copy k items to next, and the copy k items again incrementing by 1
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        
        res[0] = 0;
        if (n > 0) {
            res[1] = 1;
        }
        
        int k = 2, next = k * 2;
        
        for (int i = 2; i <= n; i++) {
            if (i == next) {
                k = next;
                next *= 2;
            }
            
            res[i] = i - k < k/2 ? res[k/2 + (i - k)] : res[k/2 + (i - k)] + 1;
        }
        
        return res;
    }
}