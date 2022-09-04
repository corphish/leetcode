// https://leetcode.com/problems/numbers-with-same-consecutive-differences
class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        Set<Integer> store = new HashSet<>();
        
        build(0, n, k, store);
        
        int[] res = new int[store.size()];
        int i = 0;
        for (int x: store) {
            res[i++] = x;
        }
        
        return res;
    }
    
    int len(int n) {
        return n < 10 ? 1 :
            n < 100 ? 2 :
            n < 1000 ? 3 :
            n < 10000 ? 4 :
            n < 100000 ? 5 :
            n < 1000000 ? 6 :
            n < 10000000 ? 7 :
            n < 100000000 ? 8 :
            n < 1000000000 ? 9 : 10;
    }
    
    void build(int num, int n, int k, Set<Integer> store) {
        if (len(num) == n) {
            store.add(num);
            return;
        }
        
        if (num == 0) {
            for (int i = 1; i <= 9; i++) {
                build(i, n, k, store);
            }
        } else {
            int last = num % 10;
            int plus = last + k;
            int minus = last - k;
            
            if (plus >= 0 && plus <= 9) {
                build(num * 10 + plus, n, k, store);
            }
            
            if (minus >= 0 && minus <= 9) {
                build(num * 10 + minus, n, k, store);
            }
        }
    }
}