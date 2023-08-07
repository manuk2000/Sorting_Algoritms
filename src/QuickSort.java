import java.util.Random;

public class QuickSort {
    static Random rand = new Random();

    public static void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int si, int ei) {
        if (si < ei) {
            int pi = partition(arr, si, ei);
            quickSort(arr, si, pi - 1);
            quickSort(arr, pi + 1, ei);
        }
    }

    private static int partition(int[] arr, int si, int ei) {
        int pi = rand.nextInt(si, ei + 1);
        Main.swap(arr, pi, ei);
        int pv = arr[ei];
        int l = si - 1;
        for (int m = si; m < ei; ++m) {
            if (arr[m] < pv) {
                ++l;
                Main.swap(arr, m, l);
            }
        }
        Main.swap(arr, l + 1, ei);
        return l + 1;
    }
}
