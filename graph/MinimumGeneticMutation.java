// https://leetcode.com/problems/minimum-genetic-mutation
class Solution {
    public int minMutation(String start, String end, String[] bank) {
        Set<String> mutations = new HashSet<>();
        mutations.add(start);
        
        if (start.equals(end)) {
            return 0;
        }
        
        for (String mutation: bank) {
            mutations.add(mutation);
        }
        
        Map<String, Set<String>> graph = new HashMap<>();
        
        for (String x: mutations) {
            for (String y: mutations) {
                if (!x.equals(y)) {
                    int dist = distance(x, y);
                    if (dist == 1) {
                        graph.computeIfAbsent(x, i -> new HashSet<>()).add(y);
                    }
                }
            }
        }
        
        Deque<Level> queue = new ArrayDeque<>();
        queue.addFirst(new Level(start, 0));
        Set<String> visited = new HashSet<>();
        
        while (!queue.isEmpty()) {
            Level l = queue.pollFirst();
            visited.add(l.s);
            
            Set<String> set = graph.get(l.s);
            if (set == null) {
                break;
            }
            
            if (set.contains(end)) {
                return l.level + 1;
            }
            
            for (String m: set) {
                if (!visited.contains(m))
                    queue.add(new Level(m, l.level + 1));
            }
        }
        
        return -1;
    }
    
    int distance(String a, String b) {
        int distance = 0;
        for (int i = 0; i < 8; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                distance++;
            }
        }
        
        return distance;
    }
    
    class Level {
        String s;
        int level;
        
        Level(String s, int level) {
            this.s = s;
            this.level = level;
        }
    }
}