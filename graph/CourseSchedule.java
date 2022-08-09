// https://leetcode.com/problems/course-schedule
class Solution {
    // 1. Build a direct graph, and its adjacency list using the prerequisites.
    //    A directed edge should exist from node A to node B if A is prerequisite of B.
    //    While building the adj, check if there is any self cycle (meaning a course is pre-requisite of itself). If so, return false
    // 2. Perform a topological sort on the adjacency list.
    // 3. In the topologically sorted result, check for cycles.
    //    For each node, check each of its neighbors:
    //    Make sure the index of the node is less than index of each of its neighbors in topologically sorted array.
    public boolean canFinish(int n, int[][] prerequisites) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        
        for (int[] req: prerequisites) {
            if (req[0] == req[1]) {
                return false;
            }
            List<Integer> l = adj.getOrDefault(req[1], new ArrayList<>());
            l.add(req[0]);
            adj.put(req[1], l);
        }
        
        /*for (var r: adj) {
            //System.out.println(Arrays.toString(r));
        }*/
        
        //System.out.println(adj);
        
        Stack<Integer> sorted = topologicalSort(adj, n);
        //System.out.println(sorted);
        
        return !hasCycle(adj, sorted, n);
    }
    
    void dfs(Map<Integer, List<Integer>> adj, int v, boolean[] visited, Stack<Integer> stack) {
        visited[v] = true;
        
        for (int x: adj.getOrDefault(v, List.of())) {
            if (!visited[x]) {
                dfs(adj, x, visited, stack);
            }
        }
        
        stack.push(v);
    }
    
    Stack<Integer> topologicalSort(Map<Integer, List<Integer>> adj, int n) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(adj, i, visited, stack);
            }
        }
        
        return stack;
    }
    
    boolean hasCycle(Map<Integer, List<Integer>> adj, Stack<Integer> sorted, int n) {
        Map<Integer, Integer> pos = new HashMap<>();
        int idx = 0;
        while (!sorted.isEmpty()) {
            pos.put(sorted.pop(), idx++);
        }
        
        //System.out.println(pos);
        
        for (int i = 0; i < n; i++) {
            //System.out.println("Checking " + i + ", neighbors = " + adj.get(i));
            for (int j: adj.getOrDefault(i, List.of())) {
                if (pos.get(i) > pos.get(j)) {
                    //System.out.println("Cycle found for " + i + " and " + j);
                    return true;
                }
            }
        }
        
        return false;
    }
}