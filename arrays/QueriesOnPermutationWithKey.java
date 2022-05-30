// https://leetcode.com/problems/queries-on-a-permutation-with-key
class Solution {
    public int[] processQueries(int[] queries, int m) {
        int[] res = new int[queries.length];
        int[] p = new int[m];
        int c = 0;
        
        for (int i = 0; i < m; i++) p[i] = i + 1;
        
        for (int x: queries) {
            int i = 0;
            for (i = 0; i < m && p[i] != x; i++);
            res[c++] = i;
            for (int j = i; j > 0; j--) {
                int t = p[j];
                p[j] = p[j - 1];
                p[j - 1] = t;
            }
        }
        
        return res;
    }
}