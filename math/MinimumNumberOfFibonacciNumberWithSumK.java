// https://leetcode.com/problems/find-the-minimum-number-of-fibonacci-numbers-whose-sum-is-k
class Solution {
    public int findMinFibonacciNumbers(int k) {
        List<Integer> fib = new ArrayList<>();
        int a = 1, b = 1;
        fib.add(a);
        fib.add(b);
        while (b <= k) {
            int t = b;
            b += a;
            a = t;
            fib.add(b);
        }
        
        return build(k, fib);
    }

    int build(int num, List<Integer> fib) {
        if (num == 0) {
            return 0;
        }

        int ix = Collections.binarySearch(fib, num);
        if (ix >= 0) {
            return 1;
        } else {
            ix = -ix - 1;
            return 1 + build(num - fib.get(ix - 1), fib);
        }
    }
}