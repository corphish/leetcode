// https://leetcode.com/problems/rle-iterator
class RLEIterator {
    
    int[] filtered;
    int ptr;

    public RLEIterator(int[] encoding) {
        // Determine the non zero values
        /*int count = 0;
        for (int i = 0; i < encoding.length; i += 2) {
            if (encoding[i] != 0) {
                count++;
            }
        }*/
        
        filtered = encoding; //new int[2 * count];
        /*for (int i = 0, j = 0; i < encoding.length; i += 2) {
            if (encoding[i] != 0) {
                filtered[j] = encoding[i];
                filtered[j + 1] = encoding[i + 1];
                j += 2;
            }
        }*/
    }
    
    public int next(int n) {
        if (ptr >= filtered.length) {
            return -1;
        }
        
        if (n <= filtered[ptr]) {
            filtered[ptr] -= n;
            return filtered[ptr + 1];
        } else {
            int curr = filtered[ptr];
            ptr += 2;
            return next(n - curr);
        }
    }
}

/**
 * Your RLEIterator object will be instantiated and called as such:
 * RLEIterator obj = new RLEIterator(encoding);
 * int param_1 = obj.next(n);
 */