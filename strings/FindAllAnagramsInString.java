// https://leetcode.com/problems/find-all-anagrams-in-a-string
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int[] freqCount = new int[32];
        char[] arr = s.toCharArray();
        char[] ann = p.toCharArray();
        
        for (char c: ann) {
            freqCount[c - 97]++;
        }
        
        int pLen = p.length();
        int l = 0, r = pLen, i;
        
        if (pLen > s.length()) return res;
        
        for (i = l; i < r; i++) {
            freqCount[arr[i] - 97]--;
        }
        
        for (; r < s.length(); l++, r++) {
            if (isAnagram(freqCount)) {
                res.add(l);
            }
            
            freqCount[arr[l] - 97]++;
            freqCount[arr[r] - 97]--;
        }
        
        if (isAnagram(freqCount)) {
            res.add(l);
        }
        
        return res;
    }
    
    private boolean isAnagram(int[] freq) {
        int sum = 0;
        for (int x: freq) sum += Math.max(0, x);
        return sum == 0;
    }
}