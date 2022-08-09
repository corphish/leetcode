import java.util.HashMap;
import java.util.Map;

/**
 * Quick union implementation of Union Find with rank support and path compression.
 * Time complexity:
 * 1. Find - O(log(N))
 * 2. Union - O(log(N))
 * 3. Connected - O(log(N))
 * 
 * Space complexity: O(N)
 */
public class QuickUnionRank<T> implements UnionFind<T> {

    // Size
    private final int size;

    // Map to store the the nodes and roots
    private final Map<T, T> roots;
    private final Map<T, Integer> ranks;
    
    public QuickUnionRank(T[] nodes) {
        this.size = nodes.length;

        roots = new HashMap<>();
        ranks = new HashMap<>();

        // Set the roots of each node to itself
        for (T node: nodes) {
            roots.put(node, node);
            ranks.put(node, 1);
        }
    }

    public static void main(String[] args) {
        UnionFind<Integer> uf = QuickUnionRank.intNodes(10);

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
        if (vertex.equals(roots.get(vertex))) {
            return vertex;
        }

        roots.put(vertex, find(roots.get(vertex)));
        return roots.get(vertex);
    }

    @Override
    public void union(T vertexA, T vertexB) {
        // Find the roots of both vertices
        T rootA = find(vertexA);
        T rootB = find(vertexB);

        // If roots dont match, then make root of 2nd vertex point to first vertex.
        // This works because vertexB's root was rootB whose root is now rootA.
        if (!rootA.equals(rootB)) {
            int rankA = ranks.get(rootA);
            int rankB = ranks.get(rootB);

            // The root that has the smaller rank, that root's root value will be changed to the one with bigger rank.
            if (rankA < rankB) {
                roots.put(rootA, rootB);
            } else if (rankB < rankA) {
                roots.put(rootB, rootA);
            } else {
                // If both are equal, we set the root of B to A and increase rank of root by 1.
                roots.put(rootB, rootA);
                ranks.put(rootA, rankA + 1);
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

    public static final QuickUnionRank<Integer> intNodes(int size) {
        Integer[] res = new Integer[size];

        for (int i = 0; i < size; i++) {
            res[i] = i;
        }

        return new QuickUnionRank<>(res);
    }
}
