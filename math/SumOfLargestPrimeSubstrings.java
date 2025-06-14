// https://leetcode.com/problems/sum-of-largest-prime-substrings/
class Solution {
    public long sumOfLargestPrimes(String s) {
        long[] largest = new long[3];

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                long x = Long.parseLong(s.substring(i, j));
                if (isPrime(x)) {
                    offer(largest, x);
                }
            }
        }

        return largest[0] + largest[1] + largest[2];
    }

    void offer(long[] largest, long x) {
        if (x > largest[0]) {
            largest[2] = largest[1];
            largest[1] = largest[0];
            largest[0] = x;
        } else if (x > largest[1] && x < largest[0]) {
            largest[2] = largest[1];
            largest[1] = x;
        } else if (x > largest[2] && x < largest[1]) {
            largest[2] = x;
        }
    }

    boolean isPrime(long n) {
        if (n == 1) {
            return false;
        }

        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}