package pinterest.Topic8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RecursionsTest {

    Recursions rec = new Recursions();

    @Test
    public void shouldValidateFibonacciWhenIsTenNumber() {
        Assertions.assertEquals(55, rec.fibonacciWithMemo(10));
    }

    @Test
    public void shouldSumWhenPassADigits() {
        Assertions.assertEquals(10, rec.sumRecursive(1234));
    }

    @Test
    public void shouldFindTargetWhenPassAnArray() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(2, 3));
        int target = 6;
        List<String> results = rec.findTarget(numbers, target);
        Assertions.assertNotNull(results);
        Assertions.assertEquals(1, results.size());
        Assertions.assertEquals("2 * 3 = 6", results.get(0));
    }


    @Test
    public void shouldNoNegativeValuesWhenNIsMinorThanZero() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> rec.fibonacciWithMemo(-1),
                "No negative values");
    }


}