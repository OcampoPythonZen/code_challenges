package algorithms;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class HackerRank {

    public static LinkedListNode mergeLists(LinkedListNode head1, LinkedListNode head2) {
        LinkedListNode dummy = new LinkedListNode(0);
        LinkedListNode current = dummy;
        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                current.next = head1;
                head1 = head1.next;
            } else {
                current.next = head2;
                head2 = head2.next;
            }
            current = current.next;
        }
        current.next = (head1 != null) ? head1 : head2;
        return dummy.next;
    }

    public static void minimumBribes(List<Integer> q) {
        int bribes = 0;
        for (int i = 0; i < q.size(); i++) {
            int sticker = q.get(i);
            if (sticker - (i + 1) > 2) {
                System.out.println("Too chaotic");
                return;
            }
            for (int j = Math.max(0, sticker - 2); j < i; j++) {
                if (q.get(j) > sticker) {
                    bribes++;
                }
            }
        }
        System.out.println(bribes);
    }

    public static String gridChallenge(List<String> grid) {
        for (int i = 0; i < grid.size(); i++) {
            char[] chars = grid.get(i).toCharArray(); // Get every position and save on a char array
            Arrays.sort(chars); // Array sorted with Arrays.sort() not Collections.sort()
            grid.set(i, new String(chars)); // Setting new values on grid position i and chars as String
        }
        int n = grid.size();
        int m = grid.get(0).length();
        for (int col = 0; col < m; col++) {
            for (int row = 0; row < n - 1; row++) {
                char current = grid.get(row).charAt(col);
                char next = grid.get(row + 1).charAt(col);
                if (current > next) {
                    return "NO";
                }
            }
        }
        return "YES";
    }


    public static int superDigit(String s, int k) {
        if (s.length() == 1 && k == 1) {
            return Integer.parseInt(s);
        }
        long sum = 0;
        for (char c : s.toCharArray()) {
            sum += Character.getNumericValue(c);
        }
        sum *= k;
        return superDigit(Long.toString(sum), 1);
    }

    public static String caesarCipher(String s, int k) {
        k = k % 26;
        char[] encrypted = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z') {
                encrypted[i] = (char) ((c - 'a' + k) % 26 + 'a');
            } else if (c >= 'A' && c <= 'Z') {
                encrypted[i] = (char) ((c - 'A' + k) % 26 + 'A');
            } else {
                encrypted[i] = c;
            }
        }
        return new String(encrypted);
    }

    public static int flippingTheMatrixOptimized(List<List<Integer>> matrix) {
        int n = matrix.size() / 2;
        int maxSum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int val1 = matrix.get(i).get(j);
                int val2 = matrix.get(i).get(2 * n - j - 1);
                int val3 = matrix.get(2 * n - i - 1).get(j);
                int val4 = matrix.get(2 * n - i - 1).get(2 * n - j - 1);
                maxSum += Math.max(Math.max(val1, val2), Math.max(val3, val4));
            }
        }
        return maxSum;
    }


    public static int flippingTheMatrix(List<List<Integer>> matrix) {
        int maxSum = 0;
        List<Integer> firstListToSwitch = new ArrayList<>();
        for (int i = 0; i < matrix.size(); i++) {
            firstListToSwitch.add(matrix.get(i).get(matrix.size() - 2));
        }
        Collections.reverse(firstListToSwitch);
        for (int i = 0; i < matrix.size(); i++) {
            matrix.get(i).set(matrix.get(i).size() - 2, firstListToSwitch.get(i));
        }
        List<Integer> secondListToSwitch = matrix.get(0);
        Collections.reverse(secondListToSwitch);
        maxSum = matrix.get(0).get(0) + matrix.get(0).get(1) + matrix.get(1).get(0) + matrix.get(1).get(1);
        return maxSum;
    }

    public static List<Integer> countingSort(List<Integer> arr) {
        List<Integer> listOfZeros = new ArrayList<>(Collections.nCopies(100, 0));
        for (int num : arr) {
            listOfZeros.set(num, listOfZeros.get(num) + 1);
        }
        return listOfZeros;
    }

    public static int diagonalDifference(List<List<Integer>> arr) {
        int rightDiagonal = 0;
        int leftDiagonal = 0;

        //rightDiagonal = arr.get(0).get(0) + arr.get(1).get(1) + arr.get(2).get(2);
        //leftDiagonal = arr.get(0).get(2) + arr.get(1).get(1) + arr.get(2).get(0);

        for (int i = 0; i < arr.size(); i++) {
            rightDiagonal += arr.get(i).get(i);
            leftDiagonal += arr.get(i).get(arr.size() - 1 - i);
        }
        return Math.abs(rightDiagonal - leftDiagonal);
    }


    public static int lonelyIntegerWithXOR(List<Integer> a) {
        int result = 0;
        for (int num : a) {
            result ^= num;
        }
        return result;
    }

    public static int lonelyIntegerWithStream(List<Integer> a) {
        Map<Integer, Integer> responses = new HashMap<>();
        a.forEach(num -> responses.put(num, responses.getOrDefault(num, 0) + 1));
        return responses
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("There is not a number once at time."));
    }

    public static int lonelyInteger(List<Integer> a) {
        Map<Integer, Integer> responses = new HashMap<>();
        for (Integer num : a) {
            responses.put(num, responses.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : responses.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        throw new IllegalArgumentException("There is not a number once at time.");
    }


    public static String timeConversionSimplified(String s) {
        String[] parts = s.split(":");
        int hour = Integer.parseInt(parts[0]);

        String meridian = parts[2].substring(2).toUpperCase();

        if (meridian.equals("AM") && hour == 12) hour = 0;
        else if (meridian.equals("PM") && hour != 12) hour += 12;
        return String.format("%02d:%s:%s", hour, parts[1], parts[2].substring(0, 2));
    }


    public static String timeConversion(String s) {
        String[] splitTime;
        splitTime = s.split(":");

        int hoursIntValue = Integer.parseInt(splitTime[0]);
        String minutesTime = splitTime[1];
        String secondsAndMeridian = splitTime[2];

        String seconds = secondsAndMeridian.substring(0, 2);
        String meridian = secondsAndMeridian.substring(2).toUpperCase();

        if (meridian.equals("AM")) {
            if (hoursIntValue == 12) hoursIntValue = 0;
        } else {
            if (hoursIntValue != 12) hoursIntValue += 12;
        }

        String hour24Format = String.format("%02d", hoursIntValue);
        return hour24Format + ":" + minutesTime + ":" + seconds;
    }

    public static void miniMaxSumWithStream(List<Integer> arr) {
        Collections.sort(arr);
        long totalSum = arr.stream().mapToLong(Integer::longValue).sum();
        long minValue = arr.get(0);
        long maxValue = arr.get(arr.size() - 1);
        long firstValueSum = totalSum - maxValue;
        long secondValueSum = totalSum - minValue;
        System.out.println(firstValueSum + " " + secondValueSum);
    }

    public static void miniMaxSum(List<Integer> arr) {
        Collections.sort(arr);
        long firstValueSum = 0;
        long secondValueSum = 0;
        //First number
        for (int j = arr.size() - 2; j >= 0; j--) {
            firstValueSum += arr.get(j);
        }
        //Second number
        for (int i = 1; i < arr.size(); i++) {
            secondValueSum += arr.get(i);
        }
        System.out.println(firstValueSum + " " + secondValueSum);
    }


    public static void plusMinus(List<Integer> arr) {
        int countPostive = 0;
        int countNegative = 0;
        int countZero = 0;

        for (Integer i : arr) {
            if (i == 0) {
                countZero++;
            } else if (i < 0) {
                countNegative++;
            } else {
                countPostive++;
            }
        }

        BigDecimal zerosResult = new BigDecimal(countZero)
                .divide(new BigDecimal(arr.size()), 6, RoundingMode.HALF_UP);

        BigDecimal negativeResult = new BigDecimal(countNegative)
                .divide(new BigDecimal(arr.size()), 6, RoundingMode.HALF_UP);

        BigDecimal positiveResult = new BigDecimal(countPostive)
                .divide(new BigDecimal(arr.size()), 6, RoundingMode.HALF_UP);

        System.out.println(positiveResult);
        System.out.println(negativeResult);
        System.out.println(zerosResult);
    }

    public static void plusMinusWithStream(List<Integer> arr) {
        Map<String, Long> counts = arr.stream()
                .collect(Collectors.groupingBy(
                        i -> (i == 0) ? "zero" : (i < 0) ? "negative" : "positive",
                        Collectors.counting()));

        BigDecimal zerosResult = new BigDecimal(counts.getOrDefault("zero", 0L))
                .divide(new BigDecimal(arr.size()), 6, RoundingMode.HALF_UP);
        BigDecimal negativeResult = new BigDecimal(counts.getOrDefault("negative", 0L))
                .divide(new BigDecimal(arr.size()), 6, RoundingMode.HALF_UP);
        BigDecimal positiveResult = new BigDecimal(counts.getOrDefault("positive", 0L))
                .divide(new BigDecimal(arr.size()), 6, RoundingMode.HALF_UP);

        System.out.println(positiveResult);
        System.out.println(negativeResult);
        System.out.println(zerosResult);
    }

}
