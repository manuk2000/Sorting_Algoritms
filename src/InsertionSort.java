public class InsertionSort {
    public static void sort(int[] arr){
//                  19 15 12 1 17 14 17 13 10 11
        for (int j = 1; j < arr.length; j++) {
            for (int i = j; i > 0 && (arr[i - 1] > arr[i]); --i) {
                    Main.swap(arr, i , i - 1);
            }
        }
    }
}
