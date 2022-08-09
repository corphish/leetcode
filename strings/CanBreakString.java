// https://leetcode.com/problems/check-if-a-string-can-break-another-string
class Solution {
    public boolean checkIfCanBreak(String s1, String s2) {
        // syz, cdi
        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();
        
        Arrays.sort(a);
        Arrays.sort(b);
        
        int i = 0;
        
        for (; i < a.length; i++) {
            if (a[i] > b[i]) {
                break;
            }
        }
        
        if (i == a.length) {
            return true;
        }
        
        for (i = 0; i < a.length; i++) {
            if (b[i] > a[i]) {
                return false;
            }
        }
        
        return true;
    }
}