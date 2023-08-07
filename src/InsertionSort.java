public class InsertionSort {
    public static void sort(int[] arr) {
        for (int j = 1; j < arr.length; j++) {                      //n
            for (int i = j; i > 0 && (arr[i - 1] > arr[i]); --i) {  //(n - 1) * n
                Main.swap(arr, i, i - 1);                         //(n - 1) * n - 1
            }
        }
    }
}
//Big O(n^2)