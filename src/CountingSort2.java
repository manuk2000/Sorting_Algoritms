import java.util.Arrays;

public class CountingSort2 {
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

        for (int i = 1; i < copyArr.length; i++) {
            copyArr[i] += copyArr[i - 1];
        }

        int[] resArr = new int[copyArr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            int current = arr[i];
            int indexInCopyArr = current - min;
            int realityIndex = --copyArr[indexInCopyArr];
            resArr[realityIndex] = current;
        }
        System.arraycopy(resArr, 0, arr, 0, arr.length);
    }
}
