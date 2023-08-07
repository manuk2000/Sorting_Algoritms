import java.util.*;
import java.util.stream.Collectors;

//It aslo works for Negative numbers
public class RadixSort {
    public static void sort(int[] arr) {
        if (arr.length == 0) {
            System.out.println("Arras is empty");
            return;
        }
        Map<Boolean, List<Integer>> partition = Arrays.stream(arr).boxed().collect(Collectors.partitioningBy(i -> i < 0));
        List<Integer> negArr = partition.get(true).stream().map(i -> -i).collect(Collectors.toList());
        List<Integer> posArr = partition.get(false);
        //to sort
        int max = Arrays.stream(arr).max().orElse(arr[0]);
        for (int step = 1; max / step > 0; step *= 10) {
            countingSort(step, negArr);
            countingSort(step, posArr);
        }

        //merge
        negArr = negArr.stream().map(i -> -i).collect(Collectors.toList());
        int size = negArr.size();
        for (int i = size - 1; i >= 0; i--) {
            arr[size - i - 1] = negArr.get(i);
        }
        for (int i = 0; i < posArr.size(); i++) {
            arr[size + i] = posArr.get(i);
        }
    }

    private static void countingSort(int step, List<Integer> arr) {

        final int SIZE = 10;

        int[] copyArr = new int[SIZE];
        for (int integer : arr) {
            ++copyArr[(integer / step) % 10];
        }
        for (int i = 1; i < copyArr.length; i++) {
            copyArr[i] += copyArr[i - 1];
        }

        int[] resArr = new int[arr.size()];
        for (int i = arr.size() - 1; i >= 0; i--) {
            int indexForCopyArr = (arr.get(i) / step) % 10;
            int realyIndex = --copyArr[indexForCopyArr];
            resArr[realyIndex] = arr.get(i);
        }
        for (int i = 0; i < arr.size(); i++) {
            arr.set(i, resArr[i]);
        }
    }
}
