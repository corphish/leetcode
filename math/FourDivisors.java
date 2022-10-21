// https://leetcode.com/problems/four-divisors
class Solution {
    public int sumFourDivisors(int[] nums) {
        int sum = 0;
        for (int x: nums) {
            int t = 0, count = 0;
            for (int i = 1; i * i <= x; i++) {
                if (x % i == 0) {
                    if (count >= 4) {
                        t = 0;
                        count = 0;
                        break;
                    }
                    t += i;
                    if (x/i != i)
                        t += x/i;
                    count += x/i == i ? 1 : 2;
                }
            }
            
            if (count == 4) {
                /// System.out.println(x + " " + t);
                sum += t;
            }
        }
        
        return sum;
    }
}