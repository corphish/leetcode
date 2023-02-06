// https://leetcode.com/problems/longest-path-with-different-adjacent-characters/
class Solution {
    int max = 1;
    public int longestPath(int[] parent, String s) {
        Map<Integer, List<Integer>> adj = new HashMap<>();

        for (int i = 1; i < parent.length; i++) {
            adj.computeIfAbsent(parent[i], x -> new ArrayList<>()).add(i);
        }

        dfs(adj, 0, s);
        return max;
    }

    Path dfs(
        Map<Integer, List<Integer>> adj,
        int curr,
        String s
    ) {
        List<Integer> list = adj.get(curr);
        Path p = new Path(1, s.charAt(curr));
        if (list == null) {
            return p;
        }

        Path max1 = null, max2 = null;

        for (int x: list) {
            Path path = dfs(adj, x, s);
            if (p.c != path.c) {
                if (max1 == null) {
                    max1 = path;
                    continue;
                }

                if (max2 == null) {
                    if (path.len > max1.len) {
                        max2 = max1;
                        max1 = path;
                    } else {
                        max2 = path;
                    }
                    continue;
                }

                if (path.len > max1.len) {
                    max2 = max1;
                    max1 = path;
                } else if (path.len > max2.len) {
                    max2 = path;
                }
            }
        }

        if (max1 == null) {
            return p;
        }

        Path res = Path.copy(p);
        res.len += max1.len;

        if (max2 == null) {
            max = Math.max(max, res.len);
        } else {
            max = Math.max(max, res.len + max2.len);
        }

        return res;
    }

    static class Path {
        int len;
        char c;

        Path(int len, char c) {
            this.len = len;
            this.c = c;
        }

        static Path copy(Path other) {
            return new Path(other.len, other.c);
        }
    }
}