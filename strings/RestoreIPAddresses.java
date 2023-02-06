// https://leetcode.com/problems/restore-ip-addresses
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        build(s, 0, 3, new Stack<>(), res);
        return res;
    }

    void build(
        String s, 
        int i, 
        int rem, 
        Stack<String> parts, 
        List<String> res
        ) {
            if (rem == 0) {
                if (s.length() - i <= 3) {
                    String sub = s.substring(i);
                    if (!sub.isEmpty() && Integer.parseInt(sub) < 256) {
                        if (sub.length() == 1 || (sub.length() > 1 && !sub.startsWith("0"))) {
                            parts.push(sub);
                            res.add(String.join(".", parts));
                            parts.pop();
                        }
                    }
                }

                return;
            }

            StringBuilder sb = new StringBuilder();

            for (int j = i; j < i + 3 && j < s.length(); j++) {
                sb.append(s.charAt(j));
                String sub = sb.toString();
                if (Integer.parseInt(sub) < 256) {
                    if (sub.length() == 1 || (sub.length() > 1 && !sub.startsWith("0"))) {
                        parts.push(sb.toString());
                        build(s, j + 1, rem - 1, parts, res);
                        parts.pop();
                    }
                } 
            }
    }
}