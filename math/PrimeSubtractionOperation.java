// https://leetcode.com/problems/prime-subtraction-operation
class Solution {
    public boolean primeSubOperation(int[] nums) {
        int max = 0;
        boolean isIncreasing = true;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            if (i > 0) {
                isIncreasing &= nums[i] > nums[i - 1];
            }
        }

        if (isIncreasing) {
            return true;
        }

        int last = 0;
        List<Integer> primes = primesUntil(max);
        for (int x: nums) {
            int ix = Collections.binarySearch(primes, x - last);
            if (ix < 0) {
                ix = -ix - 1;
            }

            ix -= 1;
            if (ix < 0) {
                if (x > last) {
                    last = x;
                    continue;
                } else {
                    return false;
                }
            }

            last = x - primes.get(ix);
        }

        return true;
    }

    List<Integer> primesUntil(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            boolean isPrime = true;
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                res.add(i);
            }
        }

        return res;
    }
}