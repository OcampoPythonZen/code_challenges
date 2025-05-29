package WalmartCodeChallenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Exercises {


    public static boolean returnK(List<Integer> arr, int k) {
        for (int i = 0; i < arr.size(); i++) {
            if ((arr.get(i) + arr.get(arr.size() - 1)) == k) {
                return true;
            }
        }
        return false;
    }


    public static List<Integer> productAllNumbers(List<Integer> arrInt) {
        int n = arrInt.size();
        List<Integer> result = new ArrayList<>(Collections.nCopies(n, 1));
        int leftProduct = 1;
        for (int i = 0; i < n; i++) {
            result.set(i, leftProduct);
            leftProduct *= arrInt.get(i);
        }
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            result.set(i, result.get(i) * rightProduct);
            rightProduct *= arrInt.get(i);
        }
        return result;
    }


    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(Arrays.asList(10, 15, 3, 8));
        System.out.println(returnK(arr, 22));
        List<Integer> arrInt = new ArrayList<>(Arrays.asList(3, 2, 1));
        System.out.println(productAllNumbers(arrInt));
        List<Integer> arrInt2 = new ArrayList<>(Arrays.asList(5, 4, 3, 2, 1));
        System.out.println(productAllNumbers(arrInt2));
    }
}
