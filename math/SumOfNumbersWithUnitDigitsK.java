// https://leetcode.com/problems/sum-of-numbers-with-units-digit-k
class Solution {
    public int minimumNumbers(int num, int k) {
        // Sum of empty set (size of set is 0) is 0
        if (num == 0) {
            return 0;
        }
        
        // Not possible to form a set if unit digit is greater than the target sum
        if (num < k) {
            return -1;
        }
        
        // If k equals num, then the set contains k only, hence size 1
        if (num == k) {
            return 1;
        }
        
        int unitOfNum = num % 10;
        int minSize = minSetSize(unitOfNum, k);
        
        // We have the min possible set size
        // Usually this should be the answer no matter how large the target sum is, as we can always
        // take numbers accordingly with unit digit as k that sums to num.
        // Only issue will be when the sum of all the minimum possible numbers with unit digit as k (k itself) is greater
        // than the required sum, where in such cases it wont be possible to form the set.
        return k * minSize > num ? -1 : minSize;
    }
    
    // Returns the minimum size of a set whose numbers (with unit digit as k), whose sum ends with the digit
    // 'unit'. Returns -1 if it is not possible.
    int minSetSize(int unit, int k) {
        for (int i = 1; i <= 10; i++) {
            if ((k * i) % 10 == unit) {
                return i;
            }
        }
        
        return -1;
    }
}