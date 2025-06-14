// https://leetcode.com/problems/count-and-say
class Solution {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }

        String x = countAndSay(n - 1);
        char[] ch = x.toCharArray();
        char last = ch[0];
        int lastCount = 1;

        String res = "";

        for (int i = 1; i < ch.length; i++) {
            if (ch[i] != last) {
                res += lastCount + "" + last;
                lastCount = 1;
            } else {
                lastCount++;
            }

            last = ch[i];
        }

        if (lastCount > 0) {
            res += lastCount + "" + last;
        }

        return res;
    }
}