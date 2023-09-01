// https://leetcode.com/problems/excel-sheet-column-title
class Solution {
    public String convertToTitle(int columnNumber) {
        if (columnNumber == 0) { return "Z"; }
        if (columnNumber < 27) {
            return "" + (char) (64 + columnNumber);
        }
        
        return convertToTitle((columnNumber - 1)/26) + convertToTitle(columnNumber % 26);
    }
}