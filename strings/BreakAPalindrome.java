// https://leetcode.com/problems/break-a-palindrome
class Solution {
    public String breakPalindrome(String palindrome) {
        char[] arr = palindrome.toCharArray();
        boolean swapped = false;
        
        // Return empty string for all single letter input
        if (arr.length == 1) {
            return "";
        }
        
        // Now we try to change the first character that is not equal to a.
        // But we can only change if the resulting string is not a palindrome.
        // Example - If the input is aabbaa, we can change the first b to a, which becomes aaaba
        // which is not a palindrome, but if the input is aaabaa, we cannot change the b as the result
        // is also a palindrome. So we avoid the middle character (in odd length input cases only).
        // Also we look at the first half of the string only, as palindromes are basically reflections of
        // half of itself, so if a substitution can be made, it will be within the first half of the string 
        // itself.
        for (int i = 0, j = arr.length - 1; i <= j; i++, j--) {
            if (i != j && arr[i] != 'a') {
                arr[i] = 'a';
                swapped = true;
                break;
            }
        }
        
        // At this point, all the letters are a or the middle letter does not allow us to make a proper
        // substitution, so we increment the last letter (guaranteed to be 'a' at this point) to obtain the
        // lexicographically smallest solution.
        if (!swapped) {
            arr[arr.length - 1]++;
        }
        
        return new String(arr);
    }
}