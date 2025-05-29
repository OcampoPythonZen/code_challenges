package pinterest.Topic4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Topic4Test {

    Topic4 topic4 = new Topic4();

    @Test
    public void shouldValidateMapForIceCreamParlor() {
        int m = 6;
        List<Integer> arr = new ArrayList<>(Arrays.asList(1, 3, 4, 5, 6));
        List<Integer> result = topic4.iceCreamParlor(m, arr);
        Assertions.assertEquals(Arrays.asList(1, 4), result);
    }

    @Test
    public void shouldReturnFalseWhenIsAColorFullNumber() {
        Assertions.assertFalse(topic4.colorFullNumbers(6556));
    }

    @Test
    public void shouldReturnTrueWhenColorFullNumberIs() {
        Assertions.assertTrue(topic4.colorFullNumbers(3245));
    }


}
