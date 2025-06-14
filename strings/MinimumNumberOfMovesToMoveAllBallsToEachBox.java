// https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box
class Solution {
    public int[] minOperations(String boxes) {
        int[] left = new int[boxes.length()];
        int[] right = new int[boxes.length()];

        for (int i = 0, cl = 0, j = left.length - 1, cr = 0; 
            i < left.length; 
            i++, j--) {
                
            if (i > 0) {
                left[i] = left[i - 1] + cl;
                right[j] = right[j + 1] + cr;
            }

            cl += boxes.charAt(i) - '0';
            cr += boxes.charAt(j) - '0';
        }

        for (int i = 0; i < left.length; i++) {
            left[i] += right[i];
        }

        return left;
    }
}