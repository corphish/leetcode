// https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses
class Solution {
    public String minRemoveToMakeValid(String s) {
        char[] arr = s.toCharArray();
        int count = 0;
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') count++;
            else if (arr[i] == ')') {
                count--;
                if (count < 0) {
                    arr[i] = 'X';
                    count = 0;
                }
            }
        }
        
        if (count > 0) {
            for (int i = arr.length - 1; i >= 0 && count > 0; i--) {
                if (arr[i] == '(') {
                    arr[i] = 'X';
                    count--;
                }
            }
        }
        
        return new String(arr).replace("X", "");
    }
}