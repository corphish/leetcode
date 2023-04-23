// https://leetcode.com/problems/design-memory-allocator
class Allocator {
    int[] mem;

    public Allocator(int n) {
        mem = new int[n];

        // Store a value in each element
        // The value would signify that "Including this element, the next <value> elements are free"
        for (int i = n - 1, j = 1; i >= 0; i--, j++) {
            mem[i] = j;
        }
    }
    
    public int allocate(int size, int mID) {
        // Find the first index where mem[i] >= size
        int allocIndex = -1;
        for (int i = 0; i < mem.length; i++) {
            if (mem[i] >= size) {
                allocIndex = i;
                break;
            }
        }

        if (allocIndex >= 0) {
            for (int i = allocIndex, j = 0; j < size; j++) {
                // Store the id as negative
                mem[i + j] = -mID;
            }
        }

        return allocIndex;
    }
    
    public int free(int mID) {
        int count = 0;
        for (int i = 0; i < mem.length; i++) {
            if (mem[i] == -mID) {
                mem[i] = 0;
                count += 1;
            }
        }

        // Re-process the array so that it can tell how many blocks are free
        for (int i = mem.length - 1; i >= 0; i--) {
            if (i == mem.length - 1) {
                if (mem[i] == 0)
                    mem[i] = 1;
            } else {
                if (mem[i] >= 0) {
                    if (mem[i + 1] > 0) {
                        mem[i] = mem[i + 1] + 1;
                    } else {
                        mem[i] = 1;
                    }
                }
            }
        }

        return count;
    }
}

/**
 * Your Allocator object will be instantiated and called as such:
 * Allocator obj = new Allocator(n);
 * int param_1 = obj.allocate(size,mID);
 * int param_2 = obj.free(mID);
 */