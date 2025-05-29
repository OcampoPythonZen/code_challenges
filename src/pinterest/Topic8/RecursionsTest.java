package pinterest.Topic8;

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
    public void shouldNoNegativeValuesWhenNIsMinorThanZero() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> rec.fibonacciWithMemo(-1),
                "No negative values");
    }


}