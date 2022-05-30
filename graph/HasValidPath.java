// https://leetcode.com/problems/find-if-path-exists-in-graph
class Solution {
    // Normal DFS from source to destination.
    // DFS algorithm.
    // 1. Create a adjacency map if not already.
    // 2. Create a stack and a visited set.
    // 3. Add the source to the stack and the visited set.
    // 4. while the stack is not empty.
    //    - pop the last element, and get its neighbors.
    //    - if the last element is destination, or the neighbors contains the destination, return true.
    //    - else add all the neighbor elements to stack that are not already visited.
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, Set<Integer>> adjacencyMap = new HashMap<>();
        
        for (int[] edge: edges) {
            int a = edge[0];
            int b = edge[1];
            
            Set<Integer> l1 = adjacencyMap.getOrDefault(a, new HashSet<>());
            Set<Integer> l2 = adjacencyMap.getOrDefault(b, new HashSet<>());
            
            l1.add(b);
            l2.add(a);
            
            adjacencyMap.put(a, l1);
            adjacencyMap.put(b, l2);
        }
        
        // Start of DFS
        Stack<Integer> stack = new Stack<>();
        stack.add(source);
        
        Set<Integer> visited = new HashSet<>();
        visited.add(source);
        
        while (!stack.isEmpty()) {
            int last = stack.pop();
            Set<Integer> neighbors = adjacencyMap.getOrDefault(last, new HashSet<>());
            if (neighbors.contains(destination)) {
                return true;
            }
            
            if (last == destination) {
                return true;
            }
            
            for (int node: neighbors) {
                if (visited.add(node)) {
                    stack.push(node);
                }
            }
        }
        
        return false;
    }
}