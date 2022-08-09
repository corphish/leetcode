// https://leetcode.com/problems/longest-substring-without-repeating-characters/
class Solution {
    // Logic: We maintain 2 pointers.
    // We increment the right pointer if the character at right pointer is not duplicate.
    // Else we increment the left pointer, removing the character pointed to by the left pointer.
    public int lengthOfLongestSubstring(String s) {
        int l = 0, r = 0, max = 0;
        Set<Character> set = new HashSet<>();
        
        for (; l < s.length();) {
            // It is important that we check this condition.
            // As in for loop we are only checking l.
            // If l == r and r is within bounds, the set will be empty hence r will move.
            if (r < s.length()) {
                char c = s.charAt(r);
                
                // If the chatacter at r is not present in set, we add it move ahead with r
                if (!set.contains(c)) {
                    r++;
                    set.add(c);
                    // size we can consider that of set as it has all the unique characters.
                    max = Math.max(max, set.size());
                } else {
                    // Else we move ahead with l, we remove the character pointed by l.
                    // If the character pointed by l is same as r, as per removal, it will also remove the character
                    // which is pointed by r. But it is ok because we are not increasing r here, and in the next iteration,
                    // the set condition will be true and the character will be correctly added to the set.
                    char x = s.charAt(l);
                    set.remove(x);
                    l++;
                }
            } else {
                // If r has reached the end, we make l reach end.
                char x = s.charAt(l);
                set.remove(x);
                l++;
            }
        }
        
        return max;
    }
}