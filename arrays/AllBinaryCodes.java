// https://leetcode.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k
class Solution {
    // In each iteration, check the value of s[i..i + k] and store it in a set
    public boolean hasAllCodes(String s, int k) {
        if (s.length() < k + 1) return false;
        Set<Integer> set = new HashSet<>();
        
        int val = 0;
        int l = 0, r = k;
        
        for (int i = 0; i < k; i++) {
            val = val * 2 + (s.charAt(i) - '0');
        }
        
        set.add(val);
        
        for (; r < s.length(); l++, r++) {
            val -= (s.charAt(l) - '0') * (1 << (k - 1));
            val = val * 2 + (s.charAt(r) - '0') ;
            set.add(val);
        }
        
        return set.size() == 1 << k;
    }
}