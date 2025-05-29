package pinterest.Topic5;

import java.util.ArrayList;
import java.util.List;

public class Topic5 {

    public void insertionSort(int n, List<Integer> arr) {
        if (n == 1) {
            System.out.println(arr.get(0));
            return;
        }
        for (int i = 1; i < n; i++) {
            int currVal = arr.get(i);
            int j = i - 1;
            while (j >= 0 && arr.get(j) > currVal) {
                arr.set(j + 1, arr.get(j));
                j--;
            }
            arr.set(j + 1, currVal);
            arr.forEach(l -> System.out.print(l + " "));
            System.out.println();
        }
    }

    public List<Integer> quickSort(List<Integer> arr) {
        if (arr.size() < 2) {
            return arr;
        }
        int pivot = arr.get(0);
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        for (int i = 1; i < arr.size(); i++) {
            int val = arr.get(i);
            if (val < pivot) left.add(val);
            else right.add(val);
        }
        List<Integer> sortedLeft = quickSort(left);
        List<Integer> sortedRight = quickSort(right);
        List<Integer> merged = new ArrayList<>();
        merged.addAll(sortedLeft);
        merged.add(pivot);
        merged.addAll(sortedRight);
        for (int num : merged) {
            System.out.print(num + " ");
        }
        System.out.println();
        return merged;
    }
}
