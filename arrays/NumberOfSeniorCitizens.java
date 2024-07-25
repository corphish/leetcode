// https://leetcode.com/problems/number-of-senior-citizens/
class Solution {
    public int countSeniors(String[] details) {
        return (int) Arrays.stream(details).map(x -> Integer.parseInt(x.substring(11, 13))).filter(x -> x > 60).count();
    }
}