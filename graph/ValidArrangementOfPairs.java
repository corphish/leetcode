// https://leetcode.com/problems/valid-arrangement-of-pairs
class Solution {
    // [1 2] [1 3] [2 1]
    // 1 <-> 2
    // i
    // v
    // 3
    public int[][] validArrangement(int[][] pairs) {
        // In-degree: Number of edges coming to a vertex
        Map<Integer, Integer> in = new HashMap<>();

        // Out-degree: Number of edges going from a vertex
        Map<Integer, Integer> out = new HashMap<>(); 

        // List of all edges originating from a vertex
        Map<Integer, LinkedList<Integer>> outEdges = new HashMap<>();

        for (int i = 0; i < pairs.length; i++) {
            int[] pair = pairs[i];

            out.put(pair[0], out.getOrDefault(pair[0], 0) + 1);
            in.put(pair[1], in.getOrDefault(pair[1], 0) + 1);

            outEdges.computeIfAbsent(pair[0], x -> new LinkedList<>()).add(i);
        }

        List<Integer> l = new ArrayList<>();

        for (int v: outEdges.keySet()) {
            if (out.getOrDefault(v, 0) - in.getOrDefault(v, 0) == 1) {
                dfs(pairs, outEdges, v, l);
            }
        }

        if (l.isEmpty()) {
            dfs(pairs, outEdges, pairs[0][0], l);
        }

        return result(l);
    }

    int[][] result(List<Integer> l) {
        int[][] res = new int[l.size() - 1][2];
        for (int i = l.size() - 2, j = 0; i >= 0; i--, j++) {
            res[j][0] = l.get(i + 1);
            res[j][1] = l.get(i);
        }

        return res;
    }

    void dfs(
        int[][] pairs,
        Map<Integer, LinkedList<Integer>> outEdges,
        int v,
        List<Integer> result
    ) {
        LinkedList<Integer> nb = outEdges.get(v);
        while (nb != null && !nb.isEmpty()) {
            dfs(pairs, outEdges, pairs[nb.poll()][1],  result);
        }


        result.add(v);
    }
}