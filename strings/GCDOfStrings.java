// https://leetcode.com/problems/greatest-common-divisor-of-strings/
class Solution {
    public String gcdOfStrings(String a, String b) {
        String min = a.length() < b.length() ? a : b;
        StringBuilder sb = new StringBuilder();
        String res = "";

        for (char c: min.toCharArray()) {
            String prefix = sb.append(c).toString();
            String x = a.replace(prefix, "");
            String y = b.replace(prefix, "");

            if (x.isEmpty() && y.isEmpty()) {
                res = prefix;
            }
        }

        return res;
    }
}