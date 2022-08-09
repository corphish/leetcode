// https://leetcode.com/problems/smallest-value-of-the-rearranged-number/
class Solution {
    public long smallestNumber(long num) {
        boolean isNegative = num < 0;
        
        // If negative, we simply sort it and return the value
        if (isNegative) {
            char[] arr = ("" + (-num)).toCharArray();
            Arrays.sort(arr);
            
            long res = 0;
            for (int i = arr.length - 1; i >= 0; i--) {
                res = res * 10 + (arr[i] - '0');
            }
            
            return -res;
        } else {
            // We still sort the digits, but we have to be clever to avoid leading zeroes
            char[] arr = ("" + num).toCharArray();
            Arrays.sort(arr);
            
            long res = 0;
            boolean isSkipping = arr[0] == '0';
            int skipIndex = -1;
            
            for (int i = 0; i < arr.length; i++) {
                if (isSkipping) {
                    if (arr[i] != '0') {
                        // We found our start
                        res = arr[i] - '0';
                        skipIndex = i;
                        isSkipping = false;
                        i = -1;
                    }
                } else {
                    if (i != skipIndex) {
                        res = res * 10 + (arr[i] - '0');
                    }
                }
            }
            
            return res;
        }
    }
}