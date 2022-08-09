// https://leetcode.com/problems/satisfiability-of-equality-equations/
class Solution {
    // 1. Build an undirected graph and its adjacency list.
    // 2. From the given equation, consider only those equations which denotes equality, if x1 == x2, then in our graph there will be an edge existing between x1 and x2. For the equations which denote inequality, store them in a separate array.
    // 3. For each of the inequation we stored in the previous step, check if there is a path in the graph from x1 and x2. If there is a path, then
    //    the equation is not valid.
    public boolean equationsPossible(String[] equations) {
        List<String> inequations = new ArrayList<>();
        Map<Character, List<Character>> adj = new HashMap<>();
        
        for (String equation: equations) {
            char op = equation.charAt(1);
            if (op == '!') {
                inequations.add(equation);
            } else {
                char x = equation.charAt(0);
                char y = equation.charAt(3);
                
                List<Character> l1 = adj.getOrDefault(x, new ArrayList<>());
                List<Character> l2 = adj.getOrDefault(y, new ArrayList<>());
                
                l1.add(y);
                l2.add(x);
                
                adj.put(x, l1);
                adj.put(y, l2);
            }
        }
        
        //System.out.println(adj);
        
        boolean isValid = true;
        for (String equation: inequations) {
            char x = equation.charAt(0);
            char y = equation.charAt(3);
            
            //System.out.println("Validating inequaltity of " + x + " and " + y);
            
            isValid &= !hasPath(adj, x, y, new HashSet<>());
        }
        
        return isValid;
    }
    
    boolean hasPath(Map<Character, List<Character>> adj, char src, char dest, Set<Character> visited) {
        if (src == dest) {
            return true;
        }
        
        visited.add(src);
        
        for (char x: adj.getOrDefault(src, new ArrayList<>())) {
            if (!visited.contains(x)) {
                if (hasPath(adj, x, dest, visited)) {
                    return true;
                }
            }
        }
        
        return false;
    }
}