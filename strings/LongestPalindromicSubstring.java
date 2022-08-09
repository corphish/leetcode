// https://leetcode.com/problems/longest-palindromic-substring/
class Solution {
    // babad
    // Starting with b -> b, ba, bab, baba, babad
    // Starting with a -> a, ab, aba, abad
    // Starting with b (3rd letter) -> b, ba, bad
    // Starting with a (4th letter) -> a, ad
    // Starting with d -> d
    
    // Properties of palindrome:
    // 1. Odd length palindrome have one letter middle which may not repeat.
    // 2. For every i in 0..n/2, values of chars at position i and n - 1 - i will be same.
    // 3. For even length, point 2 is satisfied, and the middle 2 characters are equal.
    
    // Logic:
    // 1. We pick one index i.
    // 2. We check if we can build an even length palindrome (that is if s[i] = s[i - 1]), if yes we can proceed 
    //   with building even length palindrome.
    // 3. We can build an odd length palindrome always, whose min length will be 1 with the character itself.
    // 4. For odd length, we check the characters at i - 1 and i + 1, if they are same, we proceed with 
    //    i - 2 and i + 2 and so on as long as the indexes we are checking are in bounds. We keep track
    //    of the letters and add them to a temp variable as long as the checks are valid.
    // 5. For even length, we do the same as step 4, only this time (since we already know i - 1 is same and is included as part of the palindrome), we check i - 2 and i + 1, then i - 3 and i + 2 and so on.
    public String longestPalindrome(String s) {
        if (s.length() == 1) return s;
        String res = "";
        int n = s.length();
        for (int i = 1; i < n; i++) {
            String odd = "" + s.charAt(i);
            boolean canFormEvenStrings = s.charAt(i - 1) == s.charAt(i);
            
            if (odd.length() > res.length()) {
                res = odd;
            }
            
            // We will use 2 pointers (l, r) for odd length
            // We will use 2 pointers (x, y) for even length
            int l = 1, r = 1;
            
            for (; i - l >= 0 && i + r < n; l++, r++) {
                if (i - l >= 0 && i + r < n && s.charAt(i - l) == s.charAt(i + r)) {
                    odd = s.charAt(i - l) + odd + s.charAt(i + r);
                    if (odd.length() > res.length()) {
                        //System.out.println(odd + " " + l + " " + r);
                        res = odd;
                    }
                } else {
                    break;
                }
            }
            
            if (canFormEvenStrings) {
                String even = s.charAt(i - 1) + "" + s.charAt(i);
                int x = 1, y = 1;
                //System.out.println("Even = " + even);
                
                if (even.length() > res.length()) {
                    res = even;
                }
                
                for (; i - x >= 0 && i + y < n; x++, y++) {
                    if (i - x - 1>= 0 && i + y < n && s.charAt(i - x - 1) == s.charAt(i + y)) {
                        even = s.charAt(i - x - 1) + even + s.charAt(i + y);
                        //System.out.println(even);
                        if (even.length() > res.length()) {
                            res = even;
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        
        return res;
    }
}