package algorithms;

import java.util.HashMap;
import java.util.Map;

public class TimeAndSpaceComplexity {


    public static void howManyTimesInArray(int[] arr) {
        Map<Integer, Integer> times = new HashMap<>();
        for (Integer element : arr) {
            times.put(element, times.getOrDefault(element, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : times.entrySet()) {
            System.out.println("value: " + entry.getKey() + " in " + entry.getValue() + " time(s).");
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 3, 3};
        howManyTimesInArray(arr);

    }
}
