// https://leetcode.com/problems/minimum-operations-to-make-array-equal/
class Solution {
    public int minOperations(int n) {
        // [1, 3, 5, 7, 9, 11]
        // [2, 3, 5, 7, 9, 10]
        // [3, 3, 5, 7, 9, 9]
        // [4, 3, 5, 7, 9, 8]
        // [5, 3, 5, 7, 9, 7]
        // [6, 3, 5, 7, 9, 6]
        
        // Logic: We would like to make all the elements in the array to be n.
        // We would do so by selecting indices i and n - 1 - i. So if we increase the first half of the
        // array, we automatically decrease the second half, making them equal.
        // So for each i from (0..n/2) we calculate the moves to make value at i equal to n.
        // Which is equal to n - n - (2 * i + 1);
        
        /*int count = 0;
        for (int i = 0; i < n/2; i++) {
            count += n - (2 * i + 1);
        }
        
        return count;*/
        
        int k = n/2 + (n % 2);
        
        // n - 1 + n - 3 + n - 5 + ... + n - (2 * (n/2 - 1) + 1)
        // n - 1 + n - 3 + n - 5 + ... + n - (n - 2) + 1)
        // n - 1 + n - 3 + n - 5 + ... + n - (n - 1) if even
        // n - 1 + n - 3 + n - 5 + ... + n - n if odd
        // Formula = n * (number of odd numbers present from 1 to n (we call this value k)) - k^2 (sum of 1st k odd numbers)
        
        return k * (n - k);
    }
}