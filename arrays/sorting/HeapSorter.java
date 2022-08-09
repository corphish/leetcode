import java.util.Arrays;

public class HeapSorter<T extends Comparable<T>> implements Sorter<T> {

    @Override
    public void sort(T[] arr) {
        _heapify(arr);
        for (int i = 0; i < arr.length; i++) {
            _deleteTop(arr, arr.length - i);
        }
    }

    private void _heapify(T[] arr) {
        int n = arr.length;

        for (int i = n/2 - 1; i >= 0; i--) {
            _siftDown(arr, i, arr.length);
        }
    }

    private void _deleteTop(T[] arr, int n) {
        // Delete the top element, move to last
        T temp = arr[n - 1];
        arr[n - 1] = arr[0];
        arr[0] = temp;

        _siftDown(arr, 0, n - 1);
    }

    private void _siftDown(T[] arr, int i, int n) {      
        int largest = i;  
        int leftIndex = 2 * i + 1;
        int rightIndex = 2 * i + 2;

        if (leftIndex < n && arr[leftIndex].compareTo(arr[largest]) > 0) {
            largest = leftIndex;
        }

        if (rightIndex < n && arr[rightIndex].compareTo(arr[largest]) > 0) {
            largest = rightIndex;
        }

        if (largest != i) {
            T temp = arr[largest];
            arr[largest] = arr[i];
            arr[i] = temp;

            _siftDown(arr, largest, n);
        }
    }

    @Override
    public String getAlgorithmName() {
        return "Heap Sort";
    }
    
}
