import java.util.Arrays;
import java.util.List;

public class SortingTest {

    static final int MAX_SIZE = 100000;

    public static void main(String[] args) {
        Integer[] arr = generateRandomArray();
        Integer[] expected = arr.clone();

        Arrays.sort(expected);

        List<Sorter<Integer>> sorters = Arrays.asList(
            //new SelectionSorter<>(),
            //new InsertionSorter<>(),
            //new BubbleSorter<>(),
            new MergeSorter<>(Integer.class),
            new QuickSorter<>(),
            new HeapSorter<>()
        );

        runTest(sorters, arr, expected);
    }

    static Integer[] generateRandomArray() {
        int size = MAX_SIZE + ((int) (Math.random() * MAX_SIZE));
        Integer[] arr = new Integer[size];

        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * MAX_SIZE);
        }

        return arr;
    }

    static void runTest(List<Sorter<Integer>> sorters, Integer[] arr, Integer[] expected) {
        for (Sorter<Integer> sorter: sorters) {
            Integer[] cloned = arr.clone();

            long s = System.currentTimeMillis();
            sorter.sort(cloned);
            long e = System.currentTimeMillis();

            boolean match = Arrays.equals(cloned, expected);

            System.out.println(sorter.getAlgorithmName() + " took " + (e - s) + "ms. Match = " + match);
        }
    }
}
