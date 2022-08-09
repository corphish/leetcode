// https://leetcode.com/problems/permutation-sequence
class Solution {
    // Normal permutation to generate all permutations, return the kth one.
    // Optimizations, we use int instead of string for calculations and storage.
    // We return this int as string.
    // We try to break when we have a list of size >= k.
    public String getPermutation(int n, int k) {
        boolean[] visited = new boolean[n];
        List<Integer> acc = new ArrayList<>();
        build(n, k, visited, 0, 0, acc);
        return acc.get(k - 1).toString();
    }
    
    void build(int n, int k, boolean[] visited, int curr, int len, List<Integer> acc) {
        if (len == n) {
            acc.add(curr);
            return;
        }
        
        if (acc.size() >= k) {
            return;
        }
        
        for (int i = 1; i <= n; i++) {
            if (!visited[i - 1]) {
                visited[i - 1] = true;
                build(n, k, visited, curr * 10 + i, len + 1, acc);
                visited[i - 1] = false;
                
                if (acc.size() >= k) {
                    break;
                }
            }
        }
    }
}