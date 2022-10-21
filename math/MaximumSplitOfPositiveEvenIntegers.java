// https://leetcode.com/problems/maximum-split-of-positive-even-integers/
class Solution {
    public List<Long> maximumEvenSplit(long finalSum) {
        List<Long> res = new ArrayList<>();
        
        if (finalSum % 2 == 1) return res;
        
        long n = quadraticN(finalSum) - 1;
        finalSum -= n * (n + 1);
        
        split(finalSum, n * 2, new Stack<>(), new HashSet<>(), res);
        
        for (; n > 0; n--) res.add(n * 2);
        
        return res;
    }
    
    // n2 + n - sum < 0
    long quadraticN(long sum) {
        return (-1 + ((long) Math.sqrt(1 + 4 * sum)))/2;
    }
    
    boolean split(long sum, long min, Stack<Long> path, Set<Long> used, List<Long> store) {
        //System.out.println("Sum = " + sum + ", min = " + min);
        if (sum == 0) {
            if (path.size() > store.size()) {
                store.clear();
                store.addAll(path);
            }
            
            return true;
        } 
        
        for (long i = min + 2; i <= sum; i += 2) {
            if (i == sum - i) {
                continue;
            }
            
            if (sum - i <= min && sum - i > 0) {
                continue;
            }
            
            if (used.contains(i) || used.contains(sum - i)) {
                continue;
            }
            
            path.push(i);
            used.add(i);
            
            boolean ret = split(sum - i, min, path, used, store);
            
            used.remove(i);
            path.pop();
            
            if (ret) {
                return true;
            }
        }
        
        return false;
    }
}