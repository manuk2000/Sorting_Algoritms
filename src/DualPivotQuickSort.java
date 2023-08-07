public class DualPivotQuickSort {

    private static int[] arr; // The array to be sorted

    public static void sort(int[] array) {
        arr = array; // Assign the input array to the 'arr' variable
        dualSort(0, arr.length - 1); // Call the dualSort method to sort the entire array
    }

    // The Pivot class represents a pair of indices, left and right, that delimit a partition of the array
    private record Pivot(int left, int right) {
    }

    // The main sorting function that sorts the array using dual-pivot quicksort algorithm
    private static void dualSort(int low, int high) {
        if (low >= high) { // Base case: If the low index is greater than or equal to the high index, the array is already sorted
            return;
        }

        Pivot pivot = partition(low, high); // Partition the array around two pivots and get the new pivot indices

        // Recursively sort the left and right partitions of the array
        dualSort(low, pivot.left() - 1);
        dualSort(pivot.left() + 1, pivot.right() - 1);
        dualSort(pivot.right() + 1, high);
    }

    // Partition the array into two parts around two pivot elements
    private static Pivot partition(int low, int high) {
        if (arr[low] > arr[high]) {
            swap(low, high); // Swap the elements at low and high indices if arr[low] is greater than arr[high]
        }

        int leftPivotIndex = low + 1; // The index of the left pivot element
        int rightPivotIndex = high - 1; // The index of the right pivot element

        int iterator = low + 1; // Start iterating from the element next to the low index
        while (iterator <= rightPivotIndex) {
            if (arr[iterator] < arr[low]) {
                swap(iterator++, leftPivotIndex++); // Swap the current element with the element at leftPivotIndex, and move both indices to the right
            } else if (arr[iterator] > arr[high]) {
                swap(iterator, rightPivotIndex--); // Swap the current element with the element at rightPivotIndex, and move rightPivotIndex to the left
            } else {
                iterator++; // Move to the next element if it is between the two pivot elements
            }
        }

        // Swap the pivot elements to their correct positions
        swap(low, --leftPivotIndex);
        swap(++rightPivotIndex, high);

        // Return the new pivot indices as a Pivot object
        return new Pivot(leftPivotIndex, rightPivotIndex);
    }

    // Swap two elements in the array given their indices
    private static void swap(int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
