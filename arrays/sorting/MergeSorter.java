import java.lang.reflect.Array;

public class MergeSorter<T extends Comparable<T>> implements Sorter<T> {

    Class<T> clazz;

    MergeSorter(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public void sort(T[] arr) {
        _mergeSort(arr, 0, arr.length - 1);        
    }

    private void _mergeSort(T[] arr, int low, int high) {
        if (low < high) {
            int mid = (low + high)/2;

            _mergeSort(arr, low, mid);
            _mergeSort(arr, mid + 1, high);

            _merge(arr, low, mid, high);
        }
    }

    private void _merge(T[] arr, int low, int mid, int high) {
        // Looks like we cannot easily merge in place 
        T[] temp = (T[]) Array.newInstance(clazz, high - low + 1);

        int i = low, j = mid + 1, k = 0;

        while (i <= mid && j <= high) {
            if (arr[i].compareTo(arr[j]) < 0) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= high) {
            temp[k++] = arr[j++];
        }

        for (i = 0; i < temp.length; i++) {
            arr[low + i] = temp[i];
        }
    }

    @Override
    public String getAlgorithmName() {
        return "Merge Sort";
    }
    
}
