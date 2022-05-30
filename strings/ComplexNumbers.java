// https://leetcode.com/problems/complex-number-multiplication
class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        int[] x = split(num1);
        int[] y = split(num2);
        int[] res = {0, 0};
        
        res[0] = x[0] * y[0] - x[1] * y[1];
        res[1] = x[1] * y[0] + x[0] * y[1];
        
        return res[0] + "+" + res[1] + "i";
    }
    
    int[] split(String a) {
        String[] p = a.split("\\+");
        
        return new int[] {
            Integer.parseInt(p[0]),
            Integer.parseInt(p[1].replace("i", ""))
        };
    }
}