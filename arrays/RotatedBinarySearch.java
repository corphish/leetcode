import java.util.Arrays;

public class RotatedBinarySearch {
    static final int MAX_ARRAY_SIZE = 100;
    static final int TEST_COUNT = 100;

    public static void main(String[] args) {
        int matches = 0;
        for (int i = 0; i < TEST_COUNT; i++) {
            // Generate array
            int[] testArr = generatedRotatedSortedArray();

            // Generate a random int to search
            int testNum = testArr[0] + ((int) Math.random() * (testArr[testArr.length - 1] - testArr[0]));

            int linearResult = linearSearch(testArr, testNum);
            int binaryResult = binarySearch(testArr, testNum);

            if (linearResult != binaryResult) {
                System.out.println("Failed: array = " + Arrays.toString(testArr) + ", searchKey = " + testNum + ", linear = " + linearResult + ", binaryResult = " + binaryResult);
            }

            matches += linearResult == binaryResult ? 1 : 0;
        }

        System.out.println("Matched " + matches + "/" + TEST_COUNT);
    }

    static int[] generatedSortedArray() {
        int[] arr = new int[1 + (int) (Math.random() * MAX_ARRAY_SIZE)];
        int start = (int) (Math.random() * 10);

        for (int i = 0; i < arr.length; i++) {
            arr[i] = start;
            start += 1 + (int) (Math.random() * 10);
        }

        return arr;
    }

    static int[] generatedRotatedSortedArray() {
        int[] arr = new int[1 + (int) (Math.random() * MAX_ARRAY_SIZE)];
        int start = (int) (Math.random() * 10);

        int pivot = 1 + (int) (Math.random() * arr.length);

        for (int i = pivot, j = 0; j < arr.length; i++, j++) {
            arr[i % arr.length] = start;
            start += 1 + (int) (Math.random() * 10);
        }

        return arr;
    }

    static int linearSearch(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            if (x == arr[i]) {
                return i;
            }
        }

        return -1;
    }

    static int binarySearch(int[] arr, int x) {
        return binarySearchMain(arr, 0, arr.length - 1, x);
    }

    // Logic:
    // 1. Compute mid = (low + high)/2
    // 2. if arr[mid] == key, return mid
    // 3. Else check if arr[low] to arr[mid] is sorted or not (arr[low] <= arr[mid])
    //    If so and if the key lies between this range, search it here, else search it in mid..high - 1 range.
    // 4. Else (arr[mid] to arr[high] is sorted), check if the key lies between mid and high, if yes check in this range else
    //    check in between low to mid 
    static int binarySearchMain(int[] arr, int low, int high, int key) {
        int mid = (low + high)/2;

        if (arr[mid] == key) {
            return mid;
        }

        if (arr[low] <= arr[mid]) {
            if (key >= arr[low] && key < arr[mid]) {
                return binarySearchMain(arr, low, mid - 1, key);
            } else {
                return binarySearchMain(arr, mid + 1, high, key);
            }
        } else {
            if (key >= arr[mid] && key < arr[high]) {
                return binarySearchMain(arr, mid, high - 1, key);
            } else {
                return binarySearchMain(arr, low, mid - 1, key);
            }
        }
    }
}