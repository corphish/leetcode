// https://leetcode.com/problems/number-of-nodes-in-the-sub-tree-with-the-same-label/
class Solution {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int[] res = new int[n];

        for (int[] edge: edges) {
            adj.computeIfAbsent(edge[0], x -> new ArrayList<>()).add(edge[1]);
            adj.computeIfAbsent(edge[1], x -> new ArrayList<>()).add(edge[0]);
        }

        int[] state = new int[26];
        dfs(adj, 0, labels, state, new HashSet<>(), res);
        return res;
    }

    int[] dfs(
        Map<Integer, List<Integer>> adj,
        int curr,
        String labels,
        int[] state,
        Set<Integer> visited,
        int[] res
    ) {
        res[curr]++;
        visited.add(curr);

        int label = labels.charAt(curr) - 'a';
        int[] origState = state.clone();

        List<Integer> list = adj.get(curr);
        if (list != null) {
            for (int x : list) {
                if (!visited.contains(x)) {
                    int[] newState = dfs(adj, x, labels, origState.clone(), visited, res);
                    res[curr] += newState[label];

                    for (int i = 0; i < 26; i++) {
                        state[i] += newState[i];
                    }
                }
            }
        }

        state[label]++;
        visited.remove(curr);
        
        return state;
    }
}