// https://leetcode.com/problems/lexicographically-smallest-palindrome/
class Solution {
    public String makeSmallestPalindrome(String s) {
        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length/2; i++) {
            arr[i] = (char) Math.min(arr[i], arr[arr.length - 1 - i]);
            arr[arr.length - 1 - i] = (char) Math.min(arr[i], arr[arr.length - 1 - i]);
        }

        return new String(arr);
    }
}