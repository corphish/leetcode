// https://leetcode.com/problems/lexicographically-smallest-equivalent-string/
class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        Character[] nodes = new Character[26];
        for (int i = 0; i < 26; i++) {
            nodes[i] = (char) ('a' + i);
        }


        QuickFind<Character> uf = new QuickFind<>(nodes);

        for (int i = 0; i < s1.length(); i++) {
            char a = s1.charAt(i);
            char b = s2.charAt(i);

            if (a <= b) {
                uf.union(a, b);
            } else {
                uf.union(b, a);
            }
        }

        uf.show();

        StringBuilder sb = new StringBuilder();
        for (char c: baseStr.toCharArray()) {
            sb.append(uf.find(c));
        }

        return sb.toString();
    }

    class QuickFind<T extends Comparable<T>> {
        // Size
        private final int size;

        // Map to store the the nodes and roots
        private final Map<T, T> roots;

        // We store the nodes as well
        private T[] nodes;
        
        public QuickFind(T[] nodes) {
            this.size = nodes.length;
            this.nodes = nodes;

            roots = new HashMap<>();

            // Set the roots of each node to itself
            for (T node: nodes) {
                roots.put(node, node);
            }
        }

        public T find(T vertex) {
            return roots.getOrDefault(vertex, vertex);
        }

        public void union(T vertexA, T vertexB) {
            T rootA = find(vertexA);
            T rootB = find(vertexB);

            if (rootB.compareTo(rootA) < 0) {
                T temp = rootB;
                rootB = rootA;
                rootA = temp;
            }

            if (!rootA.equals(rootB)) {
                for (T node: nodes) {
                    if (roots.get(node).equals(rootB)) {
                        roots.put(node, rootA);
                    }
                }
            }
        }

        public boolean isConnected(T vertexA, T vertexB) {
            return find(vertexA).equals(find(vertexB));
        }

        public int getSize() {
            return size;
        }

        public void show() {
            System.out.println(roots);
        }
    }

}