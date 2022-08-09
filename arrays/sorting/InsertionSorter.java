// https://en.wikipedia.org/wiki/Insertion_sort
public class InsertionSorter<T extends Comparable<T>> implements Sorter<T> {

    @Override
    public void sort(T[] arr) {
        // An element will go to its position in each iteration.
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j + 1].compareTo(arr[j]) < 0) {
                    T temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    @Override
    public String getAlgorithmName() {
        return "Insertion Sort";
    }
    
}