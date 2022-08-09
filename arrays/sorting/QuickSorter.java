public class QuickSorter<T extends Comparable<T>> implements Sorter<T> {

    @Override
    public void sort(T[] arr) {
        _quickSort(arr, 0, arr.length - 1);        
    }

    private void _quickSort(T[] arr, int low, int high) {
        if (low < high) {
            int pivot = _partition(arr, low, high);

            _quickSort(arr, low, pivot - 1);
            _quickSort(arr, pivot + 1, high);
        }
    }

    private int _partition(T[] arr, int low, int high) {
        T pivot = arr[low];
        int i = low, j = high;

        while (i < j) {
            // Find the next element which is larger than pivot
            for (; i <= high && arr[i].compareTo(pivot) <= 0; i++);

            // Find the next element which is smaller than pivot
            for (; j >= low && arr[j].compareTo(pivot) > 0; j--);

            // Swap
            if (i < j) {
                T temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap old and new pivot
        T temp = arr[j];
        arr[j] = arr[low];
        arr[low] = temp;

        return j;
    }

    @Override
    public String getAlgorithmName() {
        return "Quick Sort";
    }
    
}
