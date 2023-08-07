public class MergeSort {
    public static int[] sort(int[] arr) {
        return mergeSort(arr, 0, arr.length - 1);
    }

    public static int[] mergeSort(int[] arr, int s, int e) {
        if (e == s)
            return new int[]{arr[s]};

        int mid = (e - s) / 2 + s;

        int[] left = mergeSort(arr, s, mid);
        int[] rigth = mergeSort(arr, mid + 1, e);
        int[] tmp = merge(left, rigth);
        return tmp;
    }

    static private int[] merge(int[] left, int[] rigth) {
        int[] res = new int[left.length + rigth.length];
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < rigth.length) {
            if (left[i] < rigth[j]) {
                res[k++] = left[i++];
            } else {
                res[k++] = rigth[j++];
            }
        }
        while (i < left.length) {
            res[k++] = left[i++];
        }
        while (j < rigth.length) {
            res[k++] = rigth[j++];
        }
        return res;
    }
}
