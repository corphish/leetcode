// https://leetcode.com/problems/sequential-digits
class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        return new SequentialNumberGenerator(low).sequenceUntil(high);
    }
    
    /* How to generate a sequence?
     * 1. Start by creating an array, whose size will be the number digits in low.
     * 2. Generate the min value of that size as an array: Starting with i = 0..size - 1, sequence[i] = i + 1. Where sequence is the array
     * we are using to generate the sequential number. We keep track of this sequence. Example - If size is 4, array created will be [1, 2, 3, 4].
     * 
     * How to generate the next sequential value?
     * Take the previous array, check if the last value in the array is 9 or not, if it is 9, we have the largest sequential number of that size,
     * so its next sequential number will be the minimum sequential number of size + 1. This can be generated using the logic in step 2.
     * Example - If the array is [6, 7, 8, 9], size is 4 and last digit is 9, so the next value of sequence is min sequential number of size
     * 4 + 1 = 5, which is [1, 2, 3, 4, 5].
     *
     * If the last value is not 9, we add 1 to each element in array. Example - If the current sequence is [3, 4, 5, 6], the next sequential number
     * in its array form will be [4, 5, 6, 7].
     */
    class SequentialNumberGenerator {
        // We keep track of the current sequential number as an array in this variable.
        int[] num;
        
        // We need to pass the low value as start.
        SequentialNumberGenerator(int start) {
            // Determine the digit count of start.
            int size = digitCount(start);
            
            // We generate the min sequence of that size.
            int[] seq = genMinSequence(size);
            
            // We adjust the sequence by generating the next value as long as it is less than the passed start value.
            while (toNum(seq) < start) {
                seq = genNextSequence(seq);
            }
            
            // At this point, the value of represented by "seq" is the minimum sequential value which is >= start.
            this.num = seq;
        }
        
        // This will return the list of all sequential numbers >= start (which was mentioned while initializing this class) and <= end (specified)
        // in this funtion as parameter).
        List<Integer> sequenceUntil(int end) {
            List<Integer> res = new ArrayList<>();
            int x;
            while ((x = toNum(num)) <= end) {
                // We first add the converted array sequence to number.
                res.add(x);
                
                // We then generate the next sequence.
                num = genNextSequence(num);
            }
            
            return res;
        }
        
        // Returns the number of digits in n.
        private int digitCount(int n) {
            int count = 0;
            while (n > 0) {
                count++;
                n /= 10;
            }
            
            return count;
        }
        
        // Generates the minimum sequential number of a given size as an array.
        private int[] genMinSequence(int size) {
            int[] res = new int[size];
            for (int i = 0; i < size; i++) {
                res[i] = i + 1;
            }
            
            return res;
        }
        
        // Assuming that the passed "curr" is a sequential number, returns the next big sequential number as an array.
        private int[] genNextSequence(int[] curr) {
            int size = curr.length;
            if (curr[size - 1] == 9) {
                return genMinSequence(size + 1);
            }
            
            for (int i = 0; i < size; i++) {
                curr[i]++;
            }
            
            return curr;
        }
        
        // Converts the internal array representation of a number to actual number
        private int toNum(int[] arr) {
            int res = 0;
            for (int x: arr) res = res * 10 + x;
            return res;
        }
    }
}