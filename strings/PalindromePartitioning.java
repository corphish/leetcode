// https://leetcode.com/problems/palindrome-partitioning/
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        run(s.toCharArray(), 0, new Stack<>(), res);
        return res;
    }
    
    boolean isPalindrome(String s) {
        return new StringBuffer(s).reverse().toString().equals(s);
    }
    
    void run(char[] s, int x, Stack<String> session, List<List<String>> store) {
        if (x >= s.length) {
            if (!session.isEmpty()) {
                store.add(new ArrayList<>(session));
            }
            
            return;
        }

        StringBuilder sb = new StringBuilder();
        
        for (int i = x; i < s.length; i++) {
            String x = sb.toString();
            boolean p = isPalindrome(x);
            
            if (p) {
                session.push(x);
                run(s, i + 1, session, store);
                session.pop();
            }
        }
    }
}