// https://leetcode.com/problems/path-with-maximum-probability
class Solution {
    public double maxProbability(
        int n, 
        int[][] edges, 
        double[] succProb, 
        int start, 
        int end
    ) {
        Map<Integer, List<Pair<Double, Integer>>> adj = new HashMap<>();

        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            adj.computeIfAbsent(edge[0], x -> new ArrayList<>())
                .add(new Pair<>(succProb[i], edge[1]));
            adj.computeIfAbsent(edge[1], x -> new ArrayList<>())
                .add(new Pair<>(succProb[i], edge[0]));
        }

        double[] dist = new double[n];
        dist[start] = 1;

        PriorityQueue<Pair<Double, Integer>> queue = 
            new PriorityQueue<>(1, (a, b) -> Double.compare(b.getKey(), a.getKey()));

        queue.add(new Pair<>(0.0, start));
        while (!queue.isEmpty()) {
            var top = queue.poll();
            int u = top.getValue();
            if (!adj.containsKey(u)) continue;
            for (var p: adj.get(u)) {
                int v = p.getValue();
                if (dist[v] < dist[u] * p.getKey()) {
                    dist[v] = dist[u] * p.getKey();
                    queue.add(new Pair<>(dist[v], v));
                }
            }
        }

        return dist[end];
    }
}