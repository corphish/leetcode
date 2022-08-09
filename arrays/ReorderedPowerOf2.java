// https://leetcode.com/problems/reordered-power-of-2
class Solution {
    // Generate the powers of 2 within Integer.MAX_VALUE
    // Check if any one of them is an anagram of n.
    public boolean reorderedPowerOf2(int n) {
        int p = 1;
        for (int i = 1; i <= 30; i++, p *= 2) {
            if (isAnagram(p, n)) {
                //System.out.println("Match " + p + ", " + n);
                return true;
            }
        }
        
        return false;
    }
    
    // Anagram logic: Maintain a frequency counter.
    // Increment frequency for each letter in a.
    // Decrement frequency for each letter in b.
    // Both are anagram if every element in freq array is 0.
    boolean isAnagram(int a, int b) {
        int[] freq = new int[10];
        
        while (a > 0) {
            freq[a % 10]++;
            a /= 10;
        }
        
        while (b > 0) {
            freq[b % 10]--;
            b /= 10;
        }
        
        for (int num: freq) {
            if (num != 0) return false;
        }
        
        return true;
    }
}