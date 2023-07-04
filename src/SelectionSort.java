public class SelectionSort {
    public static void sort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            int j = i + 1;
            for ( ; j < arr.length; j++) {
                if(arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            Main.swap(arr , i ,minIndex );
        }
    }
}
