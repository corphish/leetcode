// https://leetcode.com/problems/isomorphic-strings
class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Integer, Integer> m = new HashMap<>();
        boolean[] isMap = new boolean[128];
        
        for (int i = 0; i < s.length(); i++) {
            int a = s.charAt(i);
            int b = t.charAt(i);
            
            Integer x = m.get(a);
            if (x == null) {
                if (!isMap[b]) {
                    m.put(a, b);
                    isMap[b] = true;
                } else return false;
            } else {
                if (x != b) return false;
            }
            
            //System.out.println(m);
        }
        
        return true;
    }
}