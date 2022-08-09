// https://leetcode.com/problems/html-entity-parser
class Solution {
    public String entityParser(String text) {
        return text
            .replace("&apos;", "'")
            .replace("&quot;", "\"")
            .replace("&gt;", ">")
            .replace("&lt;", "<")
            .replace("&frasl;", "/")
            .replace("&amp;", "&"); // Important to have this at last
    }
}