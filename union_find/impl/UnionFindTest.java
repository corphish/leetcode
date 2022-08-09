import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UnionFindTest {
    private static final int SIZE = 100000;

    public static void main(String args[]) {
        List<List<Integer>> connections = new ArrayList<>();
        int connectionCount = SIZE/3 + (int) (Math.random() * SIZE/2);

        List<List<Integer>> queries = new ArrayList<>();
        int queryCount = SIZE/3 + (int) (Math.random() * SIZE/2);

        while (connectionCount-- > 0) {
            connections.add(Arrays.asList((int) (Math.random() * SIZE), (int) (Math.random() * SIZE)));
        }

        while (queryCount-- > 0) {
            queries.add(Arrays.asList((int) (Math.random() * SIZE), (int) (Math.random() * SIZE)));
        }

        List<Boolean> qf = quickFind(connections, queries);
        List<Boolean> qu = quickUnion(connections, queries);
        List<Boolean> qur = quickUnionRank(connections, queries);

        System.out.println("Results match: " + (qf.equals(qu) && qf.equals(qur)));
    }

    private static List<Boolean> quickFind(List<List<Integer>> connections, List<List<Integer>> queries) {
        long ts = System.currentTimeMillis();

        UnionFind<Integer> uf = QuickFind.intNodes(SIZE);

        for (List<Integer> connection: connections) {
            uf.union(connection.get(0), connection.get(1));
        }

        List<Boolean> res = new ArrayList<>();

        for (List<Integer> query: queries) {
            res.add(uf.isConnected(query.get(0), query.get(1)));
        }

        System.out.println("QuickFind took " + (System.currentTimeMillis() - ts) + "ms.");

        return res;
    }

    private static List<Boolean> quickUnion(List<List<Integer>> connections, List<List<Integer>> queries) {
        long ts = System.currentTimeMillis();

        UnionFind<Integer> uf = QuickUnion.intNodes(SIZE);

        for (List<Integer> connection: connections) {
            uf.union(connection.get(0), connection.get(1));
        }

        List<Boolean> res = new ArrayList<>();

        for (List<Integer> query: queries) {
            res.add(uf.isConnected(query.get(0), query.get(1)));
        }

        System.out.println("QuickUnion took " + (System.currentTimeMillis() - ts) + "ms.");

        return res;
    }

    private static List<Boolean> quickUnionRank(List<List<Integer>> connections, List<List<Integer>> queries) {
        long ts = System.currentTimeMillis();

        UnionFind<Integer> uf = QuickUnionRank.intNodes(SIZE);

        for (List<Integer> connection: connections) {
            uf.union(connection.get(0), connection.get(1));
        }

        List<Boolean> res = new ArrayList<>();

        for (List<Integer> query: queries) {
            res.add(uf.isConnected(query.get(0), query.get(1)));
        }

        System.out.println("QuickUnionRank took " + (System.currentTimeMillis() - ts) + "ms.");

        return res;
    }
}
