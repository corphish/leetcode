// https://leetcode.com/problems/compare-version-numbers
import java.math.BigInteger;

class Solution {
    public int compareVersion(String v1, String v2) {
        String[] p1 = v1.split("\\.");
        String[] p2 = v2.split("\\.");
        
        int maxLen = Math.max(p1.length, p2.length);
        int[] i1 = new int[maxLen];
        int[] i2 = new int[maxLen];
        
        for (int i = 0; i < p1.length; i++) {
            i1[i] = new BigInteger(p1[i]).intValue();
        }
        
        for (int i = 0; i < p2.length; i++) {
            i2[i] = new BigInteger(p2[i]).intValue();
        }
        
        for (int i = 0; i < maxLen; i++) {
            if (i1[i] < i2[i]) return -1;
            if (i1[i] > i2[i]) return 1;
        }
        
        return 0;
    }
}