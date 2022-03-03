// https://leetcode.com/problems/reverse-vowels-of-a-string
class Solution {
    public String reverseVowels(String s) {
        int n = s.length(), l = 0, r = n - 1;
        char[] arr = s.toCharArray();
        while (l < r) {
            for (; l < n && !isVowel(arr[l]); l++);
            for (; r >= 0 && !isVowel(arr[r]); r--);
            
            if (l < r) {
                char t = arr[l];
                arr[l] = arr[r];
                arr[r] = t;
            }
            
            l++;
            r--;
        }
        
        return new String(arr);
    }
    
    boolean isVowel(char c) {
        return c == 'a' || c == 'A' || c == 'e' || c == 'E' || c == 'i' || c == 'I' || c == 'o' || c == 'O' || c == 'u' || c == 'U';
    }
}