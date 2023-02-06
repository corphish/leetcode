// https://leetcode.com/problems/minimum-time-to-collect-all-apples-in-a-tree/
class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        int totalApples = 0;

        for (boolean x: hasApple) {
            if (x) totalApples++;
        }

        if (totalApples == 0) {
            return 0;
        }

        Map<Integer, List<Integer>> adj = adjMapOf(edges);

        List<Deque<Integer>> paths = new ArrayList<>();
        dfs(adj, 0, hasApple, new ArrayDeque<>(), new HashSet<>(), paths);

        Distance dist = new Distance(totalApples);
        dfs(extractEdgesFrom(paths), 0, hasApple, new HashSet<>(), false, dist);
        return dist.value();
    }

    void dfs(
        Map<Integer, List<Integer>> adj, 
        int curr, 
        List<Boolean> hasApple,
        Deque<Integer> path, 
        Set<Integer> visited, 
        List<Deque<Integer>> paths) {

        if (visited.contains(curr)) {
            return;
        }

        visited.add(curr);
        path.add(curr);  

        if (hasApple.get(curr)) {
            paths.add(new ArrayDeque<>(path));
        }  

        List<Integer> neighbors = adj.get(curr);

        if (neighbors == null) {
            return;
        }

        for (int x: neighbors) {
            dfs(adj, x, hasApple, path, visited, paths);
        }

        visited.remove(curr);
        path.removeLast();
    }

    Map<Integer, List<Integer>> adjMapOf(int[][] edges) {
        Map<Integer, List<Integer>> adj = new HashMap<>();

        for (int[] edge: edges) {
            adj.computeIfAbsent(edge[0], x -> new ArrayList<>()).add(edge[1]);
            adj.computeIfAbsent(edge[1], x -> new ArrayList<>()).add(edge[0]);
        }

        return adj;
    }

    Map<Integer, Set<Integer>> extractEdgesFrom(List<Deque<Integer>> paths) {
        Map<Integer, Set<Integer>> adj = new HashMap<>();

        for (var path: paths) {
            int last = -1;
            for (int x: path) {
                if (last == -1) {
                    last = x;
                } else {
                    adj.computeIfAbsent(x, y -> new TreeSet<>()).add(last);
                    adj.computeIfAbsent(last, y -> new TreeSet<>()).add(x);
                    last = x;
                }
            }
        }

        return adj;
    }

    boolean dfs(
        Map<Integer, Set<Integer>> adj,
        int curr,
        List<Boolean> hasApple,
        Set<Integer> visited,
        boolean force,
        Distance dist
    ) {

        if (hasApple.get(curr)) {
            dist.incTask();
            hasApple.set(curr, false);
        }

        if (curr == 0 && dist.areTasksCompleted()) {
            return true;
        }

        if (!force) {
            if (visited.contains(curr))
                return false;
        }

        visited.add(curr);
        dist.inc();

        Set<Integer> neighbors = adj.get(curr);
        if (neighbors == null) {
            return false;
        }

        boolean didVisitAny = false;
        for (int x: neighbors) {
            if (!visited.contains(x)) {
                didVisitAny = true;
                boolean res = dfs(adj, x, hasApple, visited, false, dist);
                if (res) return true;
            }
        }

        if (!didVisitAny) {
            for (int x: neighbors) {
                boolean res = dfs(adj, x, hasApple, visited, true, dist);
                if (res) return true;
            }
        }

        visited.remove(curr);
        return false;
    }

    class Distance {
        private int dist, task;

        Distance(int totalTask) {
            this.task = totalTask;
        }

        void inc() {
            dist++;
        }

        void incTask() {
            task--;
        }

        boolean areTasksCompleted() {
            return task == 0;
        }

        int value() {
            return dist;
        }
    }
}