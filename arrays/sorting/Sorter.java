/**
 * Sorter base interface
 */
public interface Sorter<T extends Comparable<T>> {
    /**
     * Function to sort an array.
     * 
     * @param arr Array to sort.
     */
    void sort(T[] arr);

    /**
     * Returns the name of algorithm used to sort.
     * 
     * @return Algorithm name.
     */
    String getAlgorithmName();
}