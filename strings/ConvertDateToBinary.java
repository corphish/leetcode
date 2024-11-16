// https://leetcode.com/problems/convert-date-to-binary/
class Solution {
    public String convertDateToBinary(String date) {
        return Arrays.stream(date.split("-"))
            .map(x -> Integer.toBinaryString(Integer.parseInt(x)))
            .collect(Collectors.joining("-"));
    }
}