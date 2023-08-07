import java.util.Arrays;

//
public class Main {
    public static void main(String[] args) {
        int size = 8;
//        double[] arr = initDoubleArr(size);
        int[] arr = initArr(size);
//int[] arr = {20 , 8,30,5,18,35,15,41,10};
        System.out.println(Arrays.toString(arr));

        DualPivotQuickSort.sort(arr);

        System.out.println(Arrays.toString(arr));
    }

    static int[] initArr(int sizeArray) {
        int[] arr = new int[sizeArray];
        for (int i = 0; i < sizeArray; i++) {
            arr[i] = (int) (Math.random() * 100);
        }
        return arr;
    }

    static double[] initDoubleArr(int sizeArray) {
        double[] arr = new double[sizeArray];
        for (int i = 0; i < sizeArray; i++) {
            arr[i] = (double) (int) (Math.random() * 100) / 100;
        }
        return arr;
    }

    static void swap(int[] arr, int i, int j) {
//        System.out.println( i +"  "+ j);
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;

    }
}