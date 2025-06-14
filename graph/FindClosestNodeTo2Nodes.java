// https://leetcode.com/problems/find-closest-node-to-given-two-nodes/
class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        Map<Integer, Integer> d1 = distance(edges, node1);
        Map<Integer, Integer> d2 = distance(edges, node2);

        int node = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < edges.length; i++) {
            int dist1 = d1.getOrDefault(i, -1);
            int dist2 = d2.getOrDefault(i, -1);

            if (dist1 == -1 || dist2 == -1) {
                continue;
            }

            int maxDist = Math.max(dist1, dist2);
            if (maxDist < min) {
                min = maxDist;
                node = i;
            }
        }

        return node;        
    }

    Map<Integer, Integer> distance(int[] edges, int node) {
        Map<Integer, Integer> dist = new HashMap<>();
        Deque<Integer> q = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();

        q.add(node);
        dist.put(node, 0);
        visited.add(node);

        int distance = 1;

        while (!q.isEmpty()) {
            Deque<Integer> temp = new ArrayDeque<>();
            while (!q.isEmpty()) {
                int x = q.poll();

                if (edges[x] != -1 && !visited.contains(edges[x])) {
                    visited.add(edges[x]);
                    temp.add(edges[x]);
                    dist.put(edges[x], distance);
                }
            }

            distance += 1;
            q = temp;
        }

        return dist;
    }
}