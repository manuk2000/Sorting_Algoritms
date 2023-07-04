public class BubbleSort {
    public static void sort(int[] arr){
        for (int i = 0; i < arr.length ; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if(arr[j - 1] > arr[j]){
                    Main.swap(arr, j - 1 , j);
                }
            }
        }
    }
}
