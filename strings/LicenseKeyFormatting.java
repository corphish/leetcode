// https://leetcode.com/problems/license-key-formatting/
class Solution {
    public String licenseKeyFormatting(String s, int k) {
        String raw = "", res = "";
        for (String x: s.split("-")) {
            raw += x;
        }
        
        for (int i = raw.length(); i >= 0; i -= k) {
            String sub = raw.substring(Math.max(0, i - k), i);
            res = " " + sub + res;
        }
        
        return res.trim().replace(" ", "-").toUpperCase();
    }
}