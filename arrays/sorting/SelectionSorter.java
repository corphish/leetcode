public class SelectionSorter<T extends Comparable<T>> implements Sorter<T> {

    @Override
    public void sort(T[] arr) {
        int n = arr.length;
        
        // In each iteration we find the min of arr[i..n], and then swap it in ith position
        for (int i = 0; i < n; i++) {
            T min = arr[i];
            int minIndex = i;
            for (int j = i; j < n; j++) {
                if (arr[j].compareTo(min) < 0) {
                    min = arr[j];
                    minIndex = j;
                }
            }

            T temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    @Override
    public String getAlgorithmName() {
        return "Selection Sort";
    }
    
}
