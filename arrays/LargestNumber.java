// https://leetcode.com/problems/largest-number
import java.math.BigInteger;

class Solution {
    public String largestNumber(int[] nums) {
        String res = Arrays.stream(nums)
                .mapToObj(x -> "" + x)
                .sorted((a, b) -> (b + a).compareTo(a + b))
                .collect(Collectors.joining());
        
        return new BigInteger(res).toString();
    }
}