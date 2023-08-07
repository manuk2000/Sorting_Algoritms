public class ShellSort {
    public static void sort(int[] arr) {
        shellSort(arr, arr.length / 2);
    }

    private static void shellSort(int[] arr, int step) {
        while (step > 0) {
            for (int l = 0, r = step; r < arr.length; ++l, ++r) {
                if (arr[l] > arr[r]) {
                    Main.swap(arr, l, r);
                    for (int left = l - step, right = r - step; left >= 0; left -= step, right -= step) {
                        if (arr[left] > arr[right]) {
                            Main.swap(arr, left, right);
                        }
                    }
                }
            }
            step /= 2;
        }
    }
}
