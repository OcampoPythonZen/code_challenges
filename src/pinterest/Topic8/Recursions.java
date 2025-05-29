package pinterest.Topic8;

import java.util.HashMap;

public class Recursions {

    public int fibonacciWithMemo(int n) {
        HashMap<Integer, Integer> cache = new HashMap<>();
        if (n < 0) {
            throw new IllegalArgumentException("No negative values");
        }
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (cache.containsKey(n)) return cache.get(n);

        int result = fibonacciWithMemo(n - 1) + fibonacciWithMemo(n - 2);
        cache.put(n, result);
        return result;
    }

    public int sumRecursive(int digits) {
        if (digits < 10) return digits;
        int modNumber = digits % 10;
        int divNumber = digits / 10;
        return modNumber + sumRecursive(divNumber);
    }

}
