// https://leetcode.com/problems/word-pattern/
class Solution {
    public boolean wordPattern(String pattern, String s) {
        return consolidate(s.split(" ")).equals(consolidate(pattern));
    }
    
    public String consolidate(String[] s) {
        char letter = 'a';
        Map<String, Character> m = new HashMap<>();
        for (String p: s) {
            if (!m.containsKey(p)) {
                m.put(p, letter);
                letter++;
            }
        }
        
        String res = "";
        for (String p: s) res += m.get(p);
        
        //System.out.println(res);
        
        return res;
    }
    
    public String consolidate(String s) {
        char[] c = s.toCharArray();
        String[] r = new String[c.length];
        int i = 0;
        for (char x: c) r[i++] = "" + x;
        return consolidate(r);
    }
}