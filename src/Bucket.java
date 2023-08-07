import java.util.*;
import java.util.function.Function;

public class Bucket {
    // This method is the entry point for sorting an array of integers.
    public static void sort(int[] arr) {
        // Convert the input integer array to a double array and sort it.
        double[] array = Arrays.stream(arr).mapToDouble(i -> i * 1.0).toArray();

        // Sort the double array using the sort() method with a default range of [0, max_value].
        sort(array, false);

        // Convert the sorted double array back to an integer array and copy the result to the original array.
        int[] res = Arrays.stream(array).mapToInt(d -> (int) d).toArray();
        System.arraycopy(res, 0, arr, 0, arr.length);
    }

    // This method sorts the double array using the bucket sort algorithm.
    public static void sort(double[] arr, boolean isRangeOfZeroToOne) {
        // Find the maximum value in the double array.
        double max = Arrays.stream(arr).max().orElse(0);

        // Define a function to get a key for the bucket based on the element value.
        Function<Double, Integer> getKey;
        if (isRangeOfZeroToOne) {
            // If the range is [0, 1], multiply the element by 10 and use the integer part as the key.
            getKey = x -> (int) (x * 10);
        } else {
            // If the range is [0, max_value], calculate the appropriate key based on the maximum value.
            int maxDerived = calculateKey((int) max);
            getKey = x -> (int) (x / maxDerived % 10);
        }

        // Create a map to store the elements in different buckets.
        Map<Integer, List<Double>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            double currentElement = arr[i];
            // Add the current element to the appropriate bucket based on the key.
            addElementToMap(map, currentElement, getKey.apply(currentElement));
        }

        // Get the sorted result as a new double array by combining elements from the buckets.
        double[] res = sortedList(map);
        System.arraycopy(res, 0, arr, 0, arr.length);
    }

    // This method adds an element to the map, putting it in the appropriate bucket based on the key.
    private static void addElementToMap(Map<Integer, List<Double>> map, double element, int key) {
        List<Double> list = map.get(key);

        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(element);
        map.put(key, list);
    }

    // This method gets the sorted result as a new double array by merging elements from the buckets.
    private static double[] sortedList(Map<Integer, List<Double>> map) {
        // Sort the buckets based on the string representation of their elements.
        List<List<Double>> collect = map.values()
                .stream()
                .sorted(Comparator.comparing(List::toString))
                .toList();

        // Merge the elements from the sorted buckets into a new double array.
        double[] array = collect.stream()
                .flatMap(List::stream)
                .mapToDouble(Double::doubleValue)
                .sorted()
                .toArray();
        return array;
    }

    // This method calculates the key used for bucketing based on the maximum element value.
    private static int calculateKey(int element) {
        int key = 1;
        while ((element /= 10) != 0) {
            key *= 10;
        }
        return key;
    }
}
