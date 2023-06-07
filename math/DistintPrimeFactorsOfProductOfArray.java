// https://leetcode.com/problems/distinct-prime-factors-of-product-of-array
class Solution {
    public int distinctPrimeFactors(int[] nums) {
        int[] freq = new int[1000];
        int count = 0;
        for (int x: nums) {
            while (x > 1) {
                boolean isPrime = true;
                for (int i = 2; i * i <= x; i++) {
                    if (x % i == 0) {
                        freq[i] += 1;
                        x /= i;
                        isPrime = false;
                        break;
                    }
                }

                if (isPrime) {
                    freq[x] += 1;
                    break;
                }
            }
        }

        for (int x: freq) if (x > 0) count += 1;
        return count;
    }
}