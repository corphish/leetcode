import java.util.HashMap;
import java.util.Map;

/**
 * Quick union implementation of Union Find.
 * Time complexity:
 * 1. Find - O(N)
 * 2. Union - O(N)
 * 3. Connected - O(N)
 * 
 * Space complexity: O(N)
 */
public class QuickUnion<T> implements UnionFind<T> {

    // Size
    private final int size;

    // Map to store the the nodes and roots
    private final Map<T, T> roots;
    
    public QuickUnion(T[] nodes) {
        this.size = nodes.length;

        roots = new HashMap<>();

        // Set the roots of each node to itself
        for (T node: nodes) {
            roots.put(node, node);
        }
    }

    public static void main(String[] args) {
        UnionFind<Integer> uf = QuickUnion.intNodes(10);

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
        while(!vertex.equals(roots.get(vertex))) {
            vertex = roots.get(vertex);
        }

        return vertex;
    }

    @Override
    public void union(T vertexA, T vertexB) {
        // Find the roots of both vertices
        T rootA = find(vertexA);
        T rootB = find(vertexB);

        // If roots dont match, then make root of 2nd vertex point to first vertex.
        // This works because vertexB's root was rootB whose root is now rootA.
        if (!rootA.equals(rootB)) {
            roots.put(rootB, rootA);
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

    public static final QuickUnion<Integer> intNodes(int size) {
        Integer[] res = new Integer[size];

        for (int i = 0; i < size; i++) {
            res[i] = i;
        }

        return new QuickUnion<>(res);
    }
}
