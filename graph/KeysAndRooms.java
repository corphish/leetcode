// https://leetcode.com/problems/keys-and-rooms
class Solution {
    // Simple DFS and keep track of all nodes are visited.
    // Result will be whether number of nodes visited is n or not (where n is the size of rooms).
    // Make sure to visit only those nodes that aren't visited, otherwise TLE.
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> visited = new HashSet<>();
        
        stack.add(0);
        visited.add(0);
        
        while (!stack.isEmpty()) {
            int current = stack.pop();
            
            for (int neighbor: rooms.get(current)) {
                if (visited.add(neighbor)) {
                    stack.push(neighbor);
                }
            }
        }
        
        return visited.size() == rooms.size();
    }
}