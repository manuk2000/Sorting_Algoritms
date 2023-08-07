import java.util.Arrays;

public class CountingSort1 {
    public static void sort(int[] arr) {
        if (arr == null)
            return;
        int min = Arrays.stream(arr).min().getAsInt();
        int max = Arrays.stream(arr).max().getAsInt();
        if (arr.length / 3 < max - min) {
            System.out.println("Inefficient sorting for this array ");
        }
        int[] copyArr = new int[max - min + 1];
        for (int i : arr) {
            ++copyArr[i - min];
        }

        int mainIndex = 0;
        for (int i = 0; i < copyArr.length; i++) {
            int tmp = copyArr[i];
            while (tmp > 0) {
                arr[mainIndex++] = i + min;
                --tmp;
            }
        }
    }
}
