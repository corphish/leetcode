import java.util.HashMap;
import java.util.Map;

/**
 * Quick find implementation of Union Find.
 * Time complexity:
 * 1. Find - O(1)
 * 2. Union - O(N)
 * 3. Connected - O(1)
 * 
 * Space complexity: O(N)
 */
public class QuickFind<T> implements UnionFind<T> {

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

    public static void main(String[] args) {
        UnionFind<Integer> uf = QuickFind.intNodes(10);

        // Test data
        uf.union(1, 2);
        uf.union(2, 3);
        uf.union(4, 5);
        uf.union(7, 8);
        uf.union(8, 5);

        // Results
        System.out.println(uf.isConnected(1, 2));
        System.out.println(uf.isConnected(1, 3));
        System.out.println(uf.isConnected(1, 4));
        System.out.println(uf.isConnected(4, 7));
    }

    @Override
    public T find(T vertex) {
        return roots.getOrDefault(vertex, vertex);
    }

    @Override
    public void union(T vertexA, T vertexB) {
        T rootA = find(vertexA);
        T rootB = find(vertexB);

        if (!rootA.equals(rootB)) {
            for (T node: nodes) {
                if (roots.get(node).equals(rootB)) {
                    roots.put(node, rootA);
                }
            }
        }
    }

    @Override
    public boolean isConnected(T vertexA, T vertexB) {
        return find(vertexA).equals(find(vertexB));
    }

    @Override
    public int getSize() {
        return size;
    }

    public static final QuickFind<Integer> intNodes(int size) {
        Integer[] res = new Integer[size];

        for (int i = 0; i < size; i++) {
            res[i] = i;
        }

        return new QuickFind<>(res);
    }
}
