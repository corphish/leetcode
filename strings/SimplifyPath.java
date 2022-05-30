// https://leetcode.com/problems/simplify-path/
class Solution {
    public String simplifyPath(String path) {
        StringBuilder res = new StringBuilder();;
        Stack<String> items = new Stack<>();
        
        for (String x: path.split("/")) {
            if (x.equals("..")) {
                if (!items.isEmpty()) items.pop();
            } else if (x.equals(".") || x.isEmpty()) continue;
            else items.push(x);
        }
        
        for (String x: items) res.append("/").append(x);
        
        String r = res.toString();
        r = r.isEmpty() ? "/" : r;
        
        return r;
    }
}