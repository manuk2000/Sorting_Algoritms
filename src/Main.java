// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        int size = 8;
        int[] arr = initArr(size);
//        int[] arr = {14 ,10, 15, 14 };
        printArr(arr);

        arr = MergeSort.sort(arr);
        printArr(arr);
    }
    static void printArr(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    static int[] initArr(int size){
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() *10 + 10);
        }
        return arr;
    }
    static void swap(int[] arr , int i , int j){
//        System.out.println( i +"  "+ j);
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;

    }
}