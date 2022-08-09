public class BubbleSorter<T extends Comparable<T>> implements Sorter<T> {

    @Override
    public void sort(T[] arr) {
        int n = arr.length;
        
        // Compare adjacent elements.
        // In each of outer loop iteration, the max element
        // goes to its proper place one by one.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j + 1].compareTo(arr[j]) < 0) {
                    T temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    @Override
    public String getAlgorithmName() {
        return "Bubble Sort";
    }
    
}
