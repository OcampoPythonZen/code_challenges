package pinterest.Topic8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

    public List<String> findTarget(List<Integer> numbers, int target) {
        List<String> results = new ArrayList<>();
        if (numbers == null || numbers.isEmpty()) return results;
        int first = numbers.get(0);
        dfs(numbers, 1, first, String.valueOf(first), target, results);
        return results;
    }

    private static void dfs(List<Integer> numbers, int position, int current, String expression, int target, List<String> results) {
        System.out.println("At position " + position + " → Value operation: " + current + " | Expression: " + expression);
        if (position == numbers.size()) {
            if (current == target) {
                System.out.println("Target reached! " + expression + " = " + target);
                results.add(expression + " = " + target);
            }
            return;
        }
        int next = numbers.get(position);
        dfs(numbers, position + 1, current + next, expression + " + " + next, target, results);
        dfs(numbers, position + 1, current * next, expression + " * " + next, target, results);
    }
}
